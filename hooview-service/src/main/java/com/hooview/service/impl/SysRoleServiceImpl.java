package com.hooview.service.impl;

import com.hooview.Exception.RRException;
import com.hooview.api.dto.SelectRoleDTO;
import com.hooview.dao.SysRoleDao;
import com.hooview.entity.SysRoleEntity;
import com.hooview.oauth2.Constant;
import com.hooview.service.SysRoleMenuService;
import com.hooview.service.SysRoleService;
import com.hooview.service.SysUserRoleService;
import com.hooview.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserService sysUserService;

	@Override
	public SysRoleEntity queryObject(Long roleId) {
		return sysRoleDao.queryObject(roleId);
	}

	@Override
	public List<SysRoleEntity> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(@RequestBody SysRoleEntity role) {
		role.setCreateTime(new Date());
		sysRoleDao.save(role);

		//检查权限是否越权
		checkPrems(role);

		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(@RequestBody SysRoleEntity role) {
		sysRoleDao.update(role);
		;
		role.setCreateUserId(sysRoleDao.getCreateUserId(role));
		//检查权限是否越权
		checkPrems(role);

		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(@RequestBody Long[] roleIds) {
		sysRoleDao.deleteBatch(roleIds);
	}

	@Override
	public List<SelectRoleDTO> queryRoleIdList() {
		return sysRoleDao.queryRoleIdList();
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleEntity role){

		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(role.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}

		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new RRException("新增角色的权限，已超出你的权限范围");
		}
	}
	
}
