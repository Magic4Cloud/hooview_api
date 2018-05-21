package com.hooview.service;

import com.hooview.entity.SysRoleEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysRoleService {

	@RequestMapping(value="/role/queryObject",method = RequestMethod.GET)
	SysRoleEntity queryObject(Long roleId);

	@RequestMapping(value="/role/queryList",method = RequestMethod.GET)
	List<SysRoleEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/role/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/role/save",method = RequestMethod.POST)
	void save(@RequestBody SysRoleEntity role);

	@RequestMapping(value="/role/update",method = RequestMethod.POST)
	void update(@RequestBody SysRoleEntity role);

	@RequestMapping(value="/role/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Long[] roleIds);

}
