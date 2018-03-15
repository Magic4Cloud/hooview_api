package com.hooview.api.service.impl;

import com.hooview.api.dto.OpinionDTO;
import com.hooview.api.entity.OpinionEntity;
import com.hooview.api.service.OpinionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class OpinionServiceBack implements OpinionService {

	@Override
	public OpinionEntity queryObject(Long opinionId){
		return null;
	}
	
	@Override
	public List<OpinionEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(OpinionEntity opinion){

	}
	
	@Override
	public void update(OpinionEntity opinion){

	}
	
	@Override
	public void delete(Long opinionId){

	}
	
	@Override
	public void deleteBatch(Long[] opinionIds){

	}

	public List<OpinionDTO> queryByList(Map<String, Object> map) {
		return null;
	}

}
