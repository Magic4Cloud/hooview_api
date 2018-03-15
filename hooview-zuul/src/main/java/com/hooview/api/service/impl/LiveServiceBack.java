package com.hooview.api.service.impl;

import com.hooview.api.dto.CourseDTO;
import com.hooview.api.dto.LiveDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.entity.LiveEntity;
import com.hooview.api.service.LiveService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class LiveServiceBack implements LiveService {

	@Override
	public LiveInfoDTO queryObject(Long liveId){
		return null;
	}
	
	@Override
	public List<LiveEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(LiveEntity live){

	}
	
	@Override
	public void update(LiveEntity live){

	}
	
	@Override
	public void delete(Long liveId){

	}
	
	@Override
	public void deleteBatch(Map<String, Object> map){

	}

	@Override
	public LiveEntity queryByVid(String vid) {
		return null;
	}

	@Override
	public List<LiveDTO> adminList(Map<String, Object> map) {
		return null;
	}

	@Override
	public int queryAdminTotal(Map<String, Object> map) {
		return 0;
	}

	public Long queryLiveId(String vid) {
		return null;
	}

	public List<Long> queryByKeyword(String keyord) {
		return null;
	}

}
