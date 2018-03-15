package com.hooview.api.service.impl;

import com.hooview.api.dto.FansDTO;
import com.hooview.dao.SysUserDao;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hooview.api.dao.FansDao;
import com.hooview.api.entity.FansEntity;
import com.hooview.api.service.FansService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Service("fansService")
public class FansServiceImpl implements FansService {
	@Autowired
	private FansDao fansDao;
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void follow(@RequestBody FansEntity user) {
		int alreadyFollow = fansDao.followed(user);
		if(alreadyFollow == 0){
			Map<String,Object> map = new HashMap<>();
			map.put("follow",1);
			map.put("fans",1);
			map.put("fansUserId",user.getFansUserId());
			map.put("UserId",user.getUserId());
			sysUserDao.addFans(map);
			sysUserDao.addFollow(map);
		}
		int mutual = fansDao.followEach(user);
		user.setMutual(mutual);
		if(mutual>0){
			fansDao.updateMutual(user);
		}
		fansDao.follow(user);
	}

	@Override
	public void deleteFollow(FansEntity user) {
		Map<String,Object> map = new HashMap<>();
		map.put("follow",-1);
		map.put("fans",-1);
		map.put("fansUserId",user.getFansUserId());
		map.put("UserId",user.getUserId());
		sysUserDao.addFans(map);
		sysUserDao.addFollow(map);
		user.setMutual(-1);
		fansDao.updateMutual(user);
		fansDao.deleteFollow(user);
	}

	@Override
	public FansEntity queryObject(Long userId){
		return fansDao.queryObject(userId);
	}
	
	@Override
	public List<FansDTO> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return fansDao.queryFollowList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return fansDao.queryTotal(map);
	}

	@Override
	public List<FansDTO> queryFansList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return fansDao.queryFansList(query);
	}

	@Override
	public FansEntity getFollow(@RequestParam Map<String, Object> map) {
		return fansDao.getFollow(map);
	}

	@Override
	public int queryFansTotal(@RequestParam Map<String, Object> map) {
		return fansDao.queryFansTotal(map);
	}

	@Override
	public void save(FansEntity fans){
		fansDao.save(fans);
	}
	
	@Override
	public void update(FansEntity fans){
		fansDao.update(fans);
	}
	
	@Override
	public void delete(Long userId){
		fansDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		fansDao.deleteBatch(userIds);
	}
	
}
