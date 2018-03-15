package com.hooview.service;

import com.hooview.entity.SysUserTokenEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Token表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysUserTokenService {

	@RequestMapping(value="/userToken/queryByUserId",method = RequestMethod.GET)
	SysUserTokenEntity queryByUserId(Long userId);

	@RequestMapping(value="/userToken/save",method = RequestMethod.POST)
	void save(SysUserTokenEntity token);

	@RequestMapping(value="/userToken/update",method = RequestMethod.POST)
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	@RequestMapping(value="/userToken/createToken",method = RequestMethod.POST)
	String createToken(@RequestBody Long userId);

	/**
	 * 退出，修改token值
	 * @param token  用户token
	 */
	@RequestMapping(value="/userToken/logout",method = RequestMethod.POST)
	void logout(String token);

}
