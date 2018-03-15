package com.hooview.api.service.impl;

import com.hooview.api.entity.RemindEntity;
import com.hooview.api.service.RemindService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class RemindServiceBack implements RemindService {

	@Override
	public RemindEntity queryObject(Long liveId){
		return null;
	}
	
	@Override
	public List<RemindEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(RemindEntity remind){

	}
	
	@Override
	public void update(RemindEntity remind){

	}
	
	@Override
	public void delete(Long liveId){

	}
	
	@Override
	public void deleteBatch(Long[] liveIds){

	}
	
}
