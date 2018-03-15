package com.hooview.api.service.impl;

import com.hooview.api.dto.MsgDTO;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.MsgService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class MsgServiceBack implements MsgService {

	@Override
	public MsgEntity queryObject(Long msgId){
		return null;
	}
	
	@Override
	public List<MsgEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(MsgEntity msg){

	}
	
	@Override
	public void update(MsgEntity msg){

	}
	
	@Override
	public void delete(Long msgId){

	}
	
	@Override
	public void deleteBatch(Long[] msgIds){

	}

	public List<MsgDTO> queryMyList(Map<String, Object> map) {
		return null;
	}

	public int queryMyTotal(Map<String, Object> map) {
		return 0;
	}

	public int deleteMyBatch(MsgEntity msgEntity) {
		return 0;
	}

}
