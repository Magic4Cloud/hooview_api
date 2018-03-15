package com.hooview.service;

import com.hooview.service.impl.SysUserRoleServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:24
 */
@FeignClient(value = "hooview-service",fallback = SysUserRoleServiceBack.class)
public interface SysUserRoleService {

	@RequestMapping(value = "/userRole/saveOrUpdate",method = RequestMethod.POST)
	void saveOrUpdate(@RequestBody Map<String, Object> map);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	@RequestMapping(value = "/userRole/queryRoleIdList",method = RequestMethod.GET)
	List<Long> queryRoleIdList(@RequestParam("userId")Long userId);

	@RequestMapping(value = "/userRole/delete",method = RequestMethod.POST)
	void delete(@RequestParam("userId") Long userId);
}
