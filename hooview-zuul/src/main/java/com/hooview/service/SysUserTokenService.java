package com.hooview.service;

import com.hooview.entity.SysUserTokenEntity;
import com.hooview.service.impl.SysUserTokenServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户Token
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@FeignClient(value = "hooview-service",fallback = SysUserTokenServiceBack.class)
public interface SysUserTokenService {

	@RequestMapping(value = "/userToken/queryByUserId",method = RequestMethod.GET)
	SysUserTokenEntity queryByUserId(@RequestParam("userId")Long userId);

	@RequestMapping(value = "/userToken/save",method = RequestMethod.POST)
	void save(@RequestParam("token")SysUserTokenEntity token);

	@RequestMapping(value = "/userToken/update",method = RequestMethod.POST)
	void update(@RequestParam("token")SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	@RequestMapping(value = "/userToken/createToken",method = RequestMethod.POST)
	String createToken(@RequestParam("userId")Long userId);

	/**
	 * 退出，修改token值
	 * @param token  需要登出的用户token
	 */
	@RequestMapping(value = "/userToken/logout",method = RequestMethod.POST)
	void logout(@RequestParam("token")String token);

}
