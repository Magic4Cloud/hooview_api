package com.hooview.api.service.impl;

import com.hooview.api.dao.LiveDao;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.dto.LiveDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.entity.LiveEntity;
import com.hooview.api.service.LiveService;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("liveService")
public class LiveServiceImpl implements LiveService {
	@Autowired
	private LiveDao liveDao;
	
	@Override
	public LiveInfoDTO queryObject(@RequestParam Long liveId){
		return liveDao.queryadminObject(liveId);
	}
	
	@Override
	public List<LiveEntity> queryList(@RequestParam Map<String, Object> map){
		return liveDao.queryList(map);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return liveDao.queryTotal(query);
	}
	
	@Override
	public void save(@RequestBody LiveEntity live){
		liveDao.save(live);
	}
	
	@Override
	public void update(@RequestBody LiveEntity live){
		liveDao.update(live);
	}
	
	@Override
	public void delete(Long liveId){
		liveDao.delete(liveId);
	}
	
	@Override
	public void deleteBatch(@RequestBody Map<String, Object> map){
		liveDao.deleteAdminBatch(map);
	}

	public LiveEntity queryByVid(String vid) {
		return liveDao.queryByVid(vid);
	}

	@Override
	public List<LiveDTO> adminList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return liveDao.adminList(query);
	}

	@Override
	public int queryAdminTotal(@RequestParam Map<String, Object> map) {
		return liveDao.queryAdminTotal(map);
	}

	public Long queryLiveId(String vid) {
		return liveDao.queryLiveId(vid);
	}

	@Override
	public List<Long> queryByKeyword(String keyord) {
		return liveDao.queryByKeyword(keyord);
	}

}
