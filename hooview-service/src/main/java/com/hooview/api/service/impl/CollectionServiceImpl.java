package com.hooview.api.service.impl;

import com.hooview.api.dto.FinanceCollectionDTO;
import com.hooview.api.dto.LiveCollectionDTO;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.CollectionDao;
import com.hooview.api.entity.CollectionEntity;
import com.hooview.api.service.CollectionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionDao collectionDao;

	@Override
	public List<FinanceCollectionDTO> queryFinanceList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return collectionDao.queryFinanceList(query);
	}

	@Override
	public int queryFinanceTotal(@RequestParam Map<String, Object> map) {
		return collectionDao.queryFinanceTotal(map);
	}

	@Override
	public CollectionEntity queryObject(Long collectionId){
		return collectionDao.queryObject(collectionId);
	}
	
	@Override
	public List<LiveCollectionDTO> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return collectionDao.queryLiveList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return collectionDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody CollectionEntity collection){
		collectionDao.save(collection);
	}
	
	@Override
	public void update(CollectionEntity collection){
		collectionDao.update(collection);
	}
	
	@Override
	public void delete(@RequestBody Map<String,Object> map){
		collectionDao.delete(map);
	}
	
	@Override
	public void deleteBatch(@RequestBody Map<String,Object> map){
		collectionDao.deleteCollections(map);
	}

	public Long queryUserFollow(Long sourceId, Long userId, int type) {
		return collectionDao.queryUserFollow(sourceId,userId,type);
	}

	@Override
	public void deleteSource(@RequestBody Map<String, Object> map) {
		collectionDao.deleteSource(map);
	}
}
