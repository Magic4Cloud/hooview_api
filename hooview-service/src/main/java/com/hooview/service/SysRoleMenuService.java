package com.hooview.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色与菜单对应关系表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysRoleMenuService {

	@RequestMapping(value="/roleMenu/saveOrUpdate",method = RequestMethod.POST)
	void saveOrUpdate(Long roleId, List<Long> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	@RequestMapping(value="/roleMenu/queryMenuIdList",method = RequestMethod.GET)
	List<Long> queryMenuIdList(@RequestParam("roleId") Long roleId);
}
