package com.hooview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.RemindDao;
import com.hooview.api.entity.RemindEntity;
import com.hooview.api.service.RemindService;



@Service("remindService")
public class RemindServiceImpl implements RemindService {
	@Autowired
	private RemindDao remindDao;
	
	@Override
	public RemindEntity queryObject(Long liveId){
		return remindDao.queryObject(liveId);
	}
	
	@Override
	public List<RemindEntity> queryList(Map<String, Object> map){
		return remindDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return remindDao.queryTotal(map);
	}
	
	@Override
	public void save(RemindEntity remind){
		remindDao.save(remind);
	}
	
	@Override
	public void update(RemindEntity remind){
		remindDao.update(remind);
	}
	
	@Override
	public void delete(Long liveId){
		remindDao.delete(liveId);
	}
	
	@Override
	public void deleteBatch(Long[] liveIds){
		remindDao.deleteBatch(liveIds);
	}
	
}
