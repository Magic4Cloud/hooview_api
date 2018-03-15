package com.hooview.api.controller;

import com.hooview.api.dto.RegisterDTO;
import com.hooview.api.entity.CodeEntity;
import com.hooview.api.entity.UuidEntity;
import com.hooview.api.service.CodeService;
import com.hooview.api.service.UuidService;
import com.hooview.common.code.MobileCode;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class CodeController {
	@Autowired
	private CodeService codeService;
	@Autowired
	private UuidService uuidService;
	@Autowired
	MobileCode mobileCode;
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/code/list")
	@RequiresPermissions("api:code:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CodeEntity> codeList = codeService.queryList(query);
		int total = codeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(codeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/code/info/{id}")
	@RequiresPermissions("api:code:info")
	public R info(@PathVariable("id") Long id){
		CodeEntity code = codeService.queryObject(id);
		
		return R.ok().put("code", code);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/code/save")
	@RequiresPermissions("api:code:save")
	public R save(@RequestBody CodeEntity code){
		codeService.save(code);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/code/update")
	@RequiresPermissions("api:code:update")
	public R update(@RequestBody CodeEntity code){
		codeService.update(code);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/code/delete")
	@RequiresPermissions("api:code:delete")
	public R delete(@RequestBody Long[] ids){
		codeService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 获取验证码
	 */
	@RequestMapping(value = "/api/user/getcode",method = RequestMethod.POST)
	public R getcode(@RequestBody RegisterDTO register) throws IOException {
		if(register.getPhone()==null || "".equals(register.getPhone())){
			return R.error();
		}
		//用户信息
		SysUserEntity checkUser = sysUserService.queryByMobile(register.getPhone());
		//注册获取
		if(register.getType()==1){
			if(checkUser != null){
				return R.error(1,"该手机号已经注册");
			}
		}else if(register.getType()==2){
			if(checkUser == null){
				return R.error(1,"该手机号尚未注册");
			}
		}
		//发送验证码
		String code=String.valueOf((int)((Math.random()*9+1)*1000));
		if(register.getType()==1){
			mobileCode.sendSmsByLogin(code,register.getPhone());
		}else if(register.getType()==2){
			mobileCode.sendSmsByUpPw(code,register.getPhone());
		}
		Calendar nowTime = Calendar.getInstance();
		//验证码1分钟有效，为网络延迟预留1分钟时间
		nowTime.add(Calendar.MINUTE, 2);
		//保存验证码到数据库
		CodeEntity entity = new CodeEntity();
		entity.setCode(code);
		entity.setExpiretime(nowTime.getTime());
		entity.setMobile(register.getPhone());
		codeService.save(entity);
		return R.ok();
	}
	/**
	 * 验证验证码
	 */
	@RequestMapping(value = "/api/user/checkcode",method = RequestMethod.POST)
	public R checkcode(@RequestBody RegisterDTO register){
		if(register.getPhone()==null || "".equals(register.getPhone())){
			return R.error();
		}
		Map<String, Object> params = new HashMap<>();
		params.put("phone",register.getPhone());
		params.put("code",register.getCode());
		CodeEntity entity = codeService.checkcode(params);
		if(entity==null){
			return R.error(1,"验证码不正确或已过期");
		}
		UuidEntity uuidEntity = new UuidEntity();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		uuidEntity.setUuid(uuid);
		Calendar nowTime = Calendar.getInstance();
		//pwkey 30分钟有效
		nowTime.add(Calendar.MINUTE, 30);
		uuidEntity.setExpiretime(nowTime.getTime());
		uuidService.save(uuidEntity);
		return R.ok().put("pwkey",uuid);
	}
}
