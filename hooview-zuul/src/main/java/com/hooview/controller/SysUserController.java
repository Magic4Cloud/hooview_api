package com.hooview.controller;

import com.hooview.api.dto.*;
import com.hooview.common.annotation.SysLog;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import com.hooview.common.validator.Assert;
import com.hooview.common.validator.ValidatorUtils;
import com.hooview.common.validator.group.AddGroup;
import com.hooview.easemob.service.impl.EasemobIMUsers;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysUserRoleService;
import com.hooview.service.SysUserService;
import io.swagger.client.model.NewPassword;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 用户表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public class SysUserController extends AbstractController{
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private UuidService uuidService;
	@Autowired
	private EasemobIMUsers easemobIMUsers;
	@Autowired
	private AgencyService agencyService;

	/**
	 * 所有用户列表
	 */
	@RequestMapping("/admin/user/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<AnchorUserDTO> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

		return R.ok().put("userList", pageUtil);
	}


	/**
	 * 修改登录用户密码
	 */
	//@SysLog("修改密码")
	@RequestMapping("/api/user/setPassword")
	public R password(@RequestBody RegisterDTO register){
		Assert.isBlank(register.getPassword(), "新密码不为能空");
		UuidEntity uuidEntity = uuidService.queryObject(register.getPwkey());
		if(uuidEntity == null){
			return R.error(1,"设置失败，请重新获取验证码验证");
		}
		//sha256加密
		SysUserEntity user = sysUserService.queryByMobile(register.getPhone());
		String newPassword = new Sha256Hash(register.getPassword(), user.getSalt()).toHex();

		//修改环信账号密码
		NewPassword psd = new NewPassword().newpassword(register.getPassword());
		easemobIMUsers.modifyIMUserPasswordWithAdminToken(register.getPhone(),psd);

		//修改用户密码
		sysUserService.updatePassword(register.getPhone(),newPassword);
		return R.ok();
	}

	/**
	 * 用户信息
	 */
	@RequestMapping("/api/user/info")
	public R info(@RequestParam("userId") Long userId){

		SysUserEntity user = sysUserService.queryObject(getUserId());
		UserDTO userInfo = new UserDTO();
		userInfo.setAnchor(user.getAnchor());
		userInfo.setAnchorAudit(user.getAnchorAudit());
		userInfo.setFans(user.getFans());
		userInfo.setFollow(user.getFollow());
		userInfo.setHeadUrl(user.getHeadUrl());
		userInfo.setIntroduce(user.getIntroduce());
		userInfo.setMobile(user.getMobile());
		userInfo.setNickname(user.getNickname());
		userInfo.setRegion(user.getRegion());
		userInfo.setSex(user.getSex());
		userInfo.setUserId(user.getUserId());
		//获取用户所属的角色列表
		//List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		//user.setRoleIdList(roleIdList);

		return R.ok().put("userInfo", userInfo);
	}

	/**
	 * 管理端获取用户信息
	 */
	@RequestMapping("/admin/user/info")
	@RequiresPermissions("sys:user:list")
	public R admininfo(@RequestParam("userId") Long userId){

		SysUserEntity user = sysUserService.queryObject(userId);
		AdminUserDTO userInfo = new AdminUserDTO();
		userInfo.setAnchor(user.getAnchor());
		userInfo.setAnchorAudit(user.getAnchorAudit());
		userInfo.setFans(user.getFans());
		userInfo.setFollow(user.getFollow());
		userInfo.setHeadUrl(user.getHeadUrl());
		userInfo.setIntroduce(user.getIntroduce());
		userInfo.setMobile(user.getMobile());
		userInfo.setNickname(user.getNickname());
        userInfo.setUsername(user.getUsername());
		userInfo.setRegion(user.getRegion());
		userInfo.setSex(user.getSex());
		userInfo.setUserId(user.getUserId());
		userInfo.setYiId(user.getYiId());
		userInfo.setAgencyId(user.getAgencyId());
		userInfo.setLiveTypeId(user.getLiveTypeId());

		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        userInfo.setRoleIdList(roleIdList);

		return R.ok().put("userInfo", userInfo);
	}

	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/admin/user/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		if(user.getAnchor()==0){
			user.setAnchorAudit(0);
		}else{
			user.setAnchorAudit(2);
		}
		String mobile = user.getMobile();
		SysUserEntity userEntity = sysUserService.queryByMobile(mobile);
		if(userEntity != null){
			return R.error("该手机号已注册");
		}
		String pwd = user.getPassword();
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		user.setSalt(salt);
		sysUserService.save(user);
		//添加环信账号
//		RegisterUsers users = new RegisterUsers();
//		User imUser = new User().username(mobile).password(user.getPassword());
//		users.add(imUser);
//		Object o = easemobIMUsers.createNewIMUserSingle(users);
		RegisterUsers users = new RegisterUsers();
		User imUser = new User().username(user.getMobile()).password(pwd);
		users.add(imUser);
		easemobIMUsers.createNewIMUserSingle(users);
		return R.ok();
	}

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @RequestMapping("/admin/user/update")
    @RequiresPermissions("sys:user:update")
    public R adminUpdate(@RequestBody SysUserEntity user){
        ValidatorUtils.validateEntity(user, AddGroup.class);
        if(user.getUserId()==null){
            return R.error(406,"");
        }
        if(user.getAnchor()==0){
            user.setAnchorAudit(0);
        }else{
            user.setAnchorAudit(2);
        }
        user.setPassword(null);
        sysUserService.update(user);
        return R.ok();
    }

	/**
	 * 修改用户
	 */
	@SysLog("用户修改个人信息")
	@RequestMapping("/api/user/update")
	public R update(@RequestBody SysUserEntity user){
		user.setUserId(getUserId());
		sysUserService.update(user);
		return R.ok();
	}


	/**
	 * 申请主播
	 */
	@RequestMapping(value = "/api/user/applyanchor",method = RequestMethod.POST)
	public R applyAnchor(@RequestBody ApplyAnchorDTO user){
		user.setUserId(getUserId());
		sysUserService.applyAnchor(user);
		return R.ok();
	}

	/**
	 * 申请主播列表
	 */
	@RequestMapping(value = "/admin/applyAnchor/list",method = RequestMethod.GET)
	@RequiresPermissions("admin:user:anchorlist")
	public R applyAnchorList(@RequestParam Map<String, Object> params){
		Query query = new Query(params);
		List<ApplyAnchorDTO> anchorDTOList = sysUserService.queryApplyAnchorList(query);
		int total = sysUserService.queryApplyAnchorTotal(query);
		PageUtils pageUtil = new PageUtils(anchorDTOList, total, query.getLimit(), query.getPage());
		return R.ok().put("applyAnchorList", pageUtil);

	}

	/**
	 * 审核主播申请
	 */
	@RequestMapping(value = "/admin/applyAnchor/audit",method = RequestMethod.POST)
	@RequiresPermissions("admin:user:anchoraudit")
	public R auditApplyAnchor(@RequestBody SysUserEntity user){
		user.setAnchorTime(new Date());
		if(user.getAnchorAudit()==2){
			user.setAnchor(1);
		}else{
			user.setAnchor(0);
		}
		sysUserService.auditApplyAnchor(user);
		return R.ok();
	}


	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/admin/user/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}

		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}

		sysUserService.deleteBatch(userIds);

		return R.ok();
	}


	/**
	 * 注册
	 */
	@RequestMapping(value = "/api/user/register",method =  RequestMethod.POST)
	public R save(@RequestBody RegisterDTO register){
		Assert.isBlank(register.getPassword(), "密码不为能空");
		Assert.isBlank(register.getPwkey(), "密钥不为能空");
		UuidEntity uuidEntity = uuidService.queryObject(register.getPwkey());
		if(uuidEntity == null){
			return R.error(1,"注册失败，请重新获注册");
		}
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		String newPassword = new Sha256Hash(register.getPassword(), salt).toHex();

		//添加环信账号
		RegisterUsers users = new RegisterUsers();
		User imUser = new User().username(register.getPhone()).password(register.getPassword());
		users.add(imUser);
		easemobIMUsers.createNewIMUserSingle(users);
		//系统增加用户
		SysUserEntity user = new SysUserEntity();
		List<Long> roleIdList = new ArrayList<>();
		roleIdList.add(0L);//注册用户角色id
		user.setStatus(1);
		user.setNickname("火眼财经"+register.getPhone().substring(7));
		user.setFans(0);
		user.setSex(1);
		user.setAnchor(0);
		user.setAnchorAudit(0);
		user.setFollow(0);
		user.setRegion("四川.成都");
		user.setIntroduce("火眼财经，让赚钱更容易");
		user.setRoleIdList(roleIdList);
		user.setCreateTime(new Date());
		user.setPassword(newPassword);
		user.setSalt(salt);
		user.setMobile(register.getPhone());
		sysUserService.save(user);

		return R.ok();
	}

	/**
	 * 主播列表
	 */
	@RequestMapping(value = "/admin/user/anchor",method = RequestMethod.GET)
	@RequiresPermissions("admin:live:save")
	public R anchorList(@RequestParam("username") String username){

		List<AnchorDTO> userList = sysUserService.queryAnchorList(username);

		return R.ok().put("anchorList", userList);
	}

	
}
