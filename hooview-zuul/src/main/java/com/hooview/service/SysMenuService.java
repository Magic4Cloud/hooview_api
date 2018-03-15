package com.hooview.service;

import com.hooview.entity.SysMenuEntity;
import com.hooview.service.impl.SysMenuServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:16
 */
@FeignClient(value = "hooview-service",fallback = SysMenuServiceBack.class)
public interface SysMenuService {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	@RequestMapping(value = "/menu/queryListParentId",method = RequestMethod.GET)
	List<SysMenuEntity> queryListParentId(@RequestParam("parentId")Long parentId, @RequestParam("menuIdList")List<Long> menuIdList);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	@RequestMapping(value = "/menu/queryNotButtonList",method = RequestMethod.GET)
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	@RequestMapping(value = "/menu/getUserMenuList",method = RequestMethod.GET)
	List<SysMenuEntity> getUserMenuList(@RequestParam("userId")Long userId);
	
	/**
	 * 查询菜单
	 */
	@RequestMapping(value = "/menu/queryObject",method = RequestMethod.GET)
	SysMenuEntity queryObject(@RequestParam("menuId")Long menuId);
	
	/**
	 * 查询菜单列表
	 */
	@RequestMapping(value = "/menu/queryList",method = RequestMethod.GET)
	List<SysMenuEntity> queryList(@RequestParam("map")Map<String, Object> map);
	
	/**
	 * 查询总数
	 */
	@RequestMapping(value = "/menu/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam("map")Map<String, Object> map);
	
	/**
	 * 保存菜单
	 */
	@RequestMapping(value = "/menu/save",method = RequestMethod.POST)
	void save(@RequestParam("menu")SysMenuEntity menu);
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/menu/update",method = RequestMethod.POST)
	void update(@RequestParam("menu")SysMenuEntity menu);
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/menu/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestParam("menuIds")Long[] menuIds);
	
	/**
	 * 查询用户的权限列表
	 */
	@RequestMapping(value = "/menu/queryUserList",method = RequestMethod.GET)
	List<SysMenuEntity> queryUserList(@RequestParam("userId")Long userId);
}
