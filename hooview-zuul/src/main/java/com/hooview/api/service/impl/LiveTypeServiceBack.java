package com.hooview.api.service.impl;

import com.hooview.api.entity.LiveTypeEntity;
import com.hooview.api.service.LiveTypeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class LiveTypeServiceBack implements LiveTypeService {

	@Override
	public LiveTypeEntity queryObject(Integer liveTypeId){
		return null;
	}
	
	@Override
	public List<LiveTypeEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(LiveTypeEntity liveType){

	}
	
	@Override
	public void update(LiveTypeEntity liveType){

	}
	
	@Override
	public void delete(Integer liveTypeId){

	}
	
	@Override
	public void deleteBatch(Integer[] liveTypeIds){

	}
	
}
