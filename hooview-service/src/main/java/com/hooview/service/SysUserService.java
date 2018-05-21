package com.hooview.service;

import com.hooview.entity.SysUserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysUserService {

	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	@RequestMapping(value="/user/queryAllPerms",method = RequestMethod.GET)
	List<String> queryAllPerms(Long userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	@RequestMapping(value="/user/queryAllMenuId",method = RequestMethod.GET)
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户ID，查询用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/user/queryObject",method = RequestMethod.GET)
	SysUserEntity queryObject(Long userId);


	/**
	 * 查询总数
	 */
	@RequestMapping(value="/user/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	/**
	 * 查询总数
	 */
	@RequestMapping(value = "/user/queryApplyAnchorTotal",method = RequestMethod.GET)
	int queryApplyAnchorTotal(@RequestParam Map<String, Object> map);

	/**
	 * 审核主播申请
	 */
	@RequestMapping(value = "/user/auditApplyAnchor",method = RequestMethod.POST)
	void auditApplyAnchor(@RequestBody SysUserEntity user);


	/**
	 * 保存用户
	 */
	@RequestMapping(value="/user/save",method = RequestMethod.POST)
	void save(@RequestBody SysUserEntity user);

	/**
	 * 修改用户
	 */
	@RequestMapping(value="/user/update",method = RequestMethod.POST)
	void update(@RequestBody SysUserEntity user);

	/**
	 * 删除用户
	 */
	@RequestMapping(value="/user/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Long[] userIds);

	/**
	 * 修改密码
	 * @param newPassword  新密码
	 */
	@RequestMapping(value="/user/updatePassword",method = RequestMethod.POST)
	int updatePassword(String phone, String newPassword);

	@RequestMapping(value="/user/queryByMobile",method = RequestMethod.GET)
	SysUserEntity queryByMobile(String mobile);



	@RequestMapping(value="/user/queryAgencyId",method = RequestMethod.GET)
	Long queryAgencyId(@RequestParam("userId") Long userId);
}
