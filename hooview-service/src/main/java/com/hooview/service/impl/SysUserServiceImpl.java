package com.hooview.service.impl;

import com.hooview.api.dao.LiveTypeUserDao;
import com.hooview.api.dto.AnchorDTO;
import com.hooview.api.dto.AnchorUserDTO;
import com.hooview.api.dto.ApplyAnchorDTO;
import com.hooview.api.dto.UserDTO;
import com.hooview.api.entity.LiveTypeUserEntity;
import com.hooview.dao.SysUserDao;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysRoleService;
import com.hooview.service.SysUserRoleService;
import com.hooview.service.SysUserService;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private LiveTypeUserDao liveTypeUserDao;

	@Override
	public List<String> queryAllPerms(Long userId) {

		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return sysUserDao.queryAllMenuId(userId);
	}


	@Override
	public SysUserEntity queryObject(Long userId) {
		return sysUserDao.queryObject(userId);
	}

	@Override
	public List<AnchorUserDTO> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return sysUserDao.queryAnchorUser(query);
	}

	@Override
	public int queryTotal(@RequestParam Map<String, Object> map) {
		return sysUserDao.queryTotal(map);
	}

	@Override
	public void applyAnchor(@RequestBody ApplyAnchorDTO user) {
		sysUserDao.applyAnchor(user);
	}

	@Override
	public List<ApplyAnchorDTO> queryApplyAnchorList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return sysUserDao.queryApplyAnchorList(query);
	}

	@Override
	public int queryApplyAnchorTotal(@RequestParam Map<String, Object> map) {
		return sysUserDao.queryApplyAnchorTotal(map);
	}

	@Override
	public void auditApplyAnchor(@RequestBody SysUserEntity user) {
		sysUserDao.auditApplyAnchor(user);
	}

	@Override
	@Transactional
	public void save(@RequestBody SysUserEntity user) {

		sysUserDao.save(user);
		if(user.getLiveTypeId() != null){
			LiveTypeUserEntity liveTypeUserEntity = new LiveTypeUserEntity();
			liveTypeUserEntity.setUserid(user.getUserId());
			liveTypeUserEntity.setLiveTypeId(user.getLiveTypeId());
			liveTypeUserDao.save(liveTypeUserEntity);
		}


		//检查角色是否越权
		checkRole(user);
		Map<String, Object> map = new HashMap<>();
		map.put("userId",user.getUserId());
		map.put("roleIdList",user.getRoleIdList());
		sysUserRoleService.saveOrUpdate(map);
	}

	@Override
	@Transactional
	public void update(@RequestBody SysUserEntity user) {
		String url = user.getHeadUrl();
		if(url != null){
			url = url.replaceAll("&amp;","&");
			user.setHeadUrl(url);
		}
		sysUserDao.update(user);
		if(user.getLiveTypeId() != null){
			LiveTypeUserEntity liveTypeUserEntity = new LiveTypeUserEntity();
			liveTypeUserEntity.setUserid(user.getUserId());
			liveTypeUserEntity.setLiveTypeId(user.getLiveTypeId());
			liveTypeUserDao.save(liveTypeUserEntity);
		}


		//检查角色是否越权
//		checkRole(user);

		//保存用户与角色关系
		Map<String, Object> map = new HashMap<>();
		map.put("userId",user.getUserId());
		map.put("roleIdList",user.getRoleIdList());
		sysUserRoleService.saveOrUpdate(map);
	}

	@Override
	@Transactional
	public void deleteBatch(@RequestBody Long[] userId) {
		sysUserDao.deleteBatch(userId);
		liveTypeUserDao.deleteBatch(userId);
	}

	@Override
	public int updatePassword(String phone, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("mobile", phone);
		map.put("newPassword", newPassword);
		return sysUserDao.updatePassword(map);
	}

	@Override
	public SysUserEntity queryByMobile(String mobile) {
		return sysUserDao.queryByMobile(mobile);
	}

	@Override
	public List<AnchorDTO> queryAnchorList(String username) {
		return sysUserDao.queryAnchorList(username);
	}

	public UserDTO queryByYiId(String yiId) {
		return sysUserDao.queryByYiId(yiId);
	}

	@Override
	public Long queryAgencyId(Long userId) {
		return sysUserDao.queryAgencyId(userId);
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserEntity user){


		//查询用户创建的角色列表
		//List<Long> roleIdList = sysRoleService.queryRoleIdList();

		//判断是否越权
//		if(!roleIdList.containsAll(user.getRoleIdList())){
//			throw new RRException("新增用户所选角色，不是本人创建");
//		}
	}

}
