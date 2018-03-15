package com.hooview.api.service.impl;

import com.hooview.api.dao.OpinionDao;
import com.hooview.api.dto.OpinionDTO;
import com.hooview.api.entity.OpinionEntity;
import com.hooview.api.service.OpinionService;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("opinionService")
public class OpinionServiceImpl implements OpinionService {
	@Autowired
	private OpinionDao opinionDao;
	
	@Override
	public OpinionEntity queryObject(Long opinionId){
		return opinionDao.queryObject(opinionId);
	}
	
	@Override
	public List<OpinionEntity> queryList(Map<String, Object> map){
		Query query = new Query(map);
		return opinionDao.queryList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return opinionDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody OpinionEntity opinion){
		opinionDao.save(opinion);
	}
	
	@Override
	public void update(@RequestBody OpinionEntity opinion){
		opinionDao.update(opinion);
	}
	
	@Override
	public void delete(Long opinionId){
		opinionDao.delete(opinionId);
	}
	
	@Override
	public void deleteBatch(Long[] opinionIds){
		opinionDao.deleteBatch(opinionIds);
	}

	public List<OpinionDTO> queryByList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return opinionDao.queryByList(query);
	}

}
