package com.hooview.controller;


import com.hooview.common.annotation.SysLog;
import com.hooview.common.utils.Constant;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import com.hooview.common.validator.ValidatorUtils;
import com.hooview.entity.SysRoleEntity;
import com.hooview.service.SysRoleMenuService;
import com.hooview.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
public class SysRoleController extends AbstractController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	/**
	 * 角色列表
	 */
	@RequestMapping("/admin/role/list")
	@RequiresPermissions("sys:role:list")
	public R list(@RequestParam Map<String, Object> params){
		//如果不是超级管理员，则只查询自己创建的角色列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysRoleEntity> list = sysRoleService.queryList(query);
		int total = sysRoleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 角色列表
	 */
	@RequestMapping("/admin/role/select")
	@RequiresPermissions("sys:role:select")
	public R select(){
		List<SelectRoleDTO> list = sysRoleService.queryRoleIdList();
		
		return R.ok().put("selectRoleList", list);
	}
	
	/**
	 * 角色信息
	 */
	@RequestMapping("/admin/role/info")
	@RequiresPermissions("sys:role:info")
	public R info(@RequestParam("roleId") Long roleId){
		SysRoleEntity role = sysRoleService.queryObject(roleId);
		
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		
		return R.ok().put("role", role);
	}
	
	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@RequestMapping("/admin/role/saveOrUpdate")
	@RequiresPermissions("sys:role:save")
	public R save(@RequestBody SysRoleEntity role){
		ValidatorUtils.validateEntity(role);
		if(role.getRoleId()==0){
			role.setCreateUserId(getUserId());
			sysRoleService.save(role);
		}else{
			sysRoleService.update(role);
		}
		return R.ok();
	}
	
	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping("/sys/role/update")
	@RequiresPermissions("sys:role:update")
	public R update(@RequestBody SysRoleEntity role){
		ValidatorUtils.validateEntity(role);
		
		role.setCreateUserId(getUserId());
		sysRoleService.update(role);
		
		return R.ok();
	}
	
	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@RequestMapping("/admin/role/delete")
	@RequiresPermissions("sys:role:delete")
	public R delete(@RequestBody Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		
		return R.ok();
	}
}
