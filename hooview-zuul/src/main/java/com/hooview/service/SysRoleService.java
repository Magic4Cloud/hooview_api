package com.hooview.service;

import com.hooview.entity.SysRoleEntity;
import com.hooview.service.impl.SysRoleServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:52
 */
@FeignClient(value = "hooview-service",fallback = SysRoleServiceBack.class)
public interface SysRoleService {

	@RequestMapping(value = "/role/queryObject",method = RequestMethod.GET)
	SysRoleEntity queryObject(@RequestParam("roleId")Long roleId);

	@RequestMapping(value = "/role/queryList",method = RequestMethod.GET)
	List<SysRoleEntity> queryList(@RequestParam("map")Map<String, Object> map);

	@RequestMapping(value = "/role/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam("map")Map<String, Object> map);

	@RequestMapping(value = "/role/save",method = RequestMethod.POST)
	void save(@RequestBody SysRoleEntity role);

	@RequestMapping(value = "/role/update",method = RequestMethod.POST)
	void update(@RequestBody SysRoleEntity role);

	@RequestMapping(value = "/role/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] roleIds);
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	@RequestMapping(value = "/role/queryRoleIdList",method = RequestMethod.GET)
	List<SelectRoleDTO> queryRoleIdList();

}
