package com.hooview.api.service.impl;

import com.hooview.api.dto.HistoryDTO;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.BrowseHistoryDao;
import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.api.service.BrowseHistoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Service("browseHistoryService")
public class BrowseHistoryServiceImpl implements BrowseHistoryService {
	@Autowired
	private BrowseHistoryDao browseHistoryDao;
	
	@Override
	public BrowseHistoryEntity queryObject(Long browseHistoryId){
		return browseHistoryDao.queryObject(browseHistoryId);
	}
	
	@Override
	public List<HistoryDTO> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return browseHistoryDao.queryHistoryList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return browseHistoryDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody BrowseHistoryEntity browseHistory){
		browseHistoryDao.save(browseHistory);
	}
	
	@Override
	public void update(BrowseHistoryEntity browseHistory){
		browseHistoryDao.update(browseHistory);
	}
	
	@Override
	public void delete(Long browseHistoryId){
		browseHistoryDao.delete(browseHistoryId);
	}
	
	@Override
	public void deleteBatch(@RequestBody BrowseHistoryEntity browseHistory){
		browseHistoryDao.deleteBrowseHistory(browseHistory);
	}

	@Override
	public void deleteSource(@RequestBody Map<String, Object> map) {
		browseHistoryDao.deleteSource(map);
	}
}
