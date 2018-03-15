package com.hooview.api.service.impl;

import com.hooview.api.dto.FinanceCollectionDTO;
import com.hooview.api.dto.LiveCollectionDTO;
import com.hooview.api.entity.CollectionEntity;
import com.hooview.api.service.CollectionService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;



@Component
public class CollectionServiceBack implements CollectionService {

	@Override
	public CollectionEntity queryObject(Long collectionId){
		return null;
	}
	
	@Override
	public List<LiveCollectionDTO> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}

	@Override
	public List<FinanceCollectionDTO> queryFinanceList(Map<String, Object> map) {
		return null;
	}

	@Override
	public int queryFinanceTotal(Map<String, Object> map) {
		return 0;
	}

	@Override
	public void save(CollectionEntity collection){

	}
	
	@Override
	public void update(CollectionEntity collection){

	}
	
	@Override
	public void delete(@RequestBody Map<String,Object> map){

	}
	
	@Override
	public void deleteBatch(Map<String,Object> map){

	}

	public Long queryUserFollow(Long sourceId, Long userId, int type) {
		return null;
	}

	@Override
	public void deleteSource(Map<String, Object> map) {

	}
}
