package com.hooview.service;

import com.hooview.service.impl.SysRoleMenuServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



/**
 * 角色与菜单对应关系
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:30
 */
@FeignClient(value = "hooview-service",fallback = SysRoleMenuServiceBack.class)
public interface SysRoleMenuService {

	@RequestMapping(value = "/roleMenu/saveOrUpdate",method = RequestMethod.POST)
	void saveOrUpdate(@RequestParam("roleId")Long roleId, @RequestParam("menuIdList")List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	@RequestMapping(value = "/roleMenu/queryMenuIdList",method = RequestMethod.GET)
	List<Long> queryMenuIdList(@RequestParam("roleId")Long roleId);
	
}
