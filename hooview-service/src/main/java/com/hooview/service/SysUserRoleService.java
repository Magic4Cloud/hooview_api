package com.hooview.service;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysUserRoleService {

	@RequestMapping(value="/userRole/saveOrUpdate",method = RequestMethod.POST)
	void saveOrUpdate(@RequestBody Map<String, Object> map);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	@RequestMapping(value="/userRole/queryRoleIdList",method = RequestMethod.GET)
	List<Long> queryRoleIdList(@RequestParam("userId") Long userId);

	@RequestMapping(value="/userRole/delete",method = RequestMethod.POST)
	void delete(Long userId);
}
