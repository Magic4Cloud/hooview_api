package com.hooview.service;

import com.hooview.entity.SysUserEntity;
import com.hooview.service.impl.SysUserServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@FeignClient(value = "hooview-service",fallback = SysUserServiceBack.class)
public interface SysUserService {

	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	@RequestMapping(value = "/user/queryAllPerms",method = RequestMethod.GET)
	List<String> queryAllPerms(@RequestParam("userId")Long userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	@RequestMapping(value = "/user/queryAllMenuId",method = RequestMethod.GET)
	List<Long> queryAllMenuId(@RequestParam("userId")Long userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	@RequestMapping(value = "/user/queryByUserName",method = RequestMethod.GET)
	SysUserEntity queryByUserName(@RequestParam("username")String username);

	/**
	 * 根据用户ID，查询用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/queryObject",method = RequestMethod.GET)
	SysUserEntity queryObject(@RequestParam("userId")Long userId);

	/**
	 * 查询用户列表
	 */
	@RequestMapping(value = "/user/queryList",method = RequestMethod.GET)
	List<AnchorUserDTO> queryList(@RequestParam("map")Map<String, Object> map);

	/**
	 * 查询总数
	 */
	@RequestMapping(value = "/user/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam("map") Map<String, Object> map);

	/**
	 * 查询申请主播列表
	 */
	@RequestMapping(value = "/user/ApplyAnchorList",method = RequestMethod.GET)
	List<ApplyAnchorDTO> queryApplyAnchorList(@RequestParam("map")Map<String, Object> map);

	/**
	 * 查询申请主播de总数
	 */
	@RequestMapping(value = "/user/queryApplyAnchorTotal",method = RequestMethod.GET)
	int queryApplyAnchorTotal(@RequestParam("map")Map<String, Object> map);

	/**
	 * 保存用户
	 */
	@RequestMapping(value = "/user/save",method = RequestMethod.POST)
	void save(@RequestBody SysUserEntity user);

	/**
	 * 修改用户
	 */
	@RequestMapping(value = "/user/update",method = RequestMethod.POST)
	void update(@RequestBody SysUserEntity user);

	@RequestMapping(value = "/user/apply",method = RequestMethod.POST)
	void applyAnchor(@RequestBody ApplyAnchorDTO user);

	/**
	 * 审核主播申请
	 */
	@RequestMapping(value = "/user/auditApplyAnchor",method = RequestMethod.POST)
	void auditApplyAnchor(@RequestBody SysUserEntity user);

	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/user/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] userIds);

	/**
	 * 修改密码
	 * @param phone
	 * @param newPassword  新密码
	 */
	@RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST)
	int updatePassword(@RequestParam("phone") String phone, @RequestParam("newPassword") String newPassword);

	@RequestMapping(value = "/user/queryByMobile",method = RequestMethod.GET)
	SysUserEntity queryByMobile(@RequestParam("mobile")String mobile);

	@RequestMapping(value="/user/queryAnchorList",method = RequestMethod.GET)
	List<AnchorDTO> queryAnchorList(@RequestParam("username") String username);

	@RequestMapping(value="/user/queryByYiId",method = RequestMethod.GET)
	UserDTO queryByYiId(@RequestParam("yiId") String yiId);

	@RequestMapping(value="/user/queryAgencyId",method = RequestMethod.GET)
	Long queryAgencyId(@RequestParam("userId") Long userId);
}
