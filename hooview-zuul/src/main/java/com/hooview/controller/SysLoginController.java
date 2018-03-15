package com.hooview.controller;

import com.hooview.api.dto.RegisterDTO;
import com.hooview.common.utils.R;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysUserRoleService;
import com.hooview.service.SysUserService;
import com.hooview.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 登录相关
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
public class SysLoginController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserTokenService sysUserTokenService;

	/**
	 * 登录
	 */
	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody RegisterDTO register,HttpServletRequest request)throws IOException {

		return this.userLogin(register.getPhone(),register.getPassword(),request);
	}

	/**
	 * 后端登录
	 */
	@RequestMapping(value = "/admin/user/login", method = RequestMethod.POST)
	public Map<String, Object> adminLogin(@RequestBody RegisterDTO register, HttpServletRequest request)throws IOException {

		return this.userLogin(register.getPhone(),register.getPassword(),request);
	}

	public R userLogin(String phone, String password, HttpServletRequest request){
		//用户信息
		SysUserEntity user = sysUserService.queryByMobile(phone);
		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}


		List<Long> roleList = sysUserRoleService.queryRoleIdList(user.getUserId());
		 if(request.getRequestURI().contains("admin")){
		 	for(Long roleId : roleList){
		 		if(roleId == 2||roleId==3){
					return R.error("你没有后台管理权限");
				}
			}
		 }else{
		 	for(Long roleId : roleList){
		 		if(roleId == 1){
					return R.error("后端管理用戶");
				}
			}
		 }

		//生成token，并保存到数据库
		String token = sysUserTokenService.createToken(user.getUserId());
		return R.ok().put("token",token).put("userId",user.getUserId());
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/api/user/logout", method = RequestMethod.POST)
	public R logout(HttpServletRequest request) {
		String token = request.getHeader("token");
		sysUserTokenService.logout(token);
		return R.ok();
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/admin/user/logout", method = RequestMethod.POST)
	public R adminlogout(HttpServletRequest request) {
		String token = request.getHeader("token");
		sysUserTokenService.logout(token);
		return R.ok();
	}
}
