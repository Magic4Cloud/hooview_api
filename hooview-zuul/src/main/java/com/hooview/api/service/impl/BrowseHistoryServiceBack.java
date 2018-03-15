package com.hooview.api.service.impl;

import com.hooview.api.dto.HistoryDTO;
import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.service.BrowseHistoryService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;



@Component
public class BrowseHistoryServiceBack implements BrowseHistoryService {

	@Override
	public BrowseHistoryEntity queryObject(Long browseHistoryId){
		return null;
	}
	
	@Override
	public List<HistoryDTO> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(BrowseHistoryEntity browseHistory){

	}
	
	@Override
	public void update(BrowseHistoryEntity browseHistory){

	}
	
	@Override
	public void delete(Long browseHistoryId){

	}
	
	@Override
	public void deleteBatch(@RequestBody BrowseHistoryEntity browseHistory){

	}

	@Override
	public void deleteSource(@RequestBody Map<String,Object> map) {

	}
}
