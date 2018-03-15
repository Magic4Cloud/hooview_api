package com.hooview.api.service.impl;

import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.OpenApplyDao;
import com.hooview.api.entity.OpenApplyEntity;
import com.hooview.api.service.OpenApplyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Service("openApplyService")
public class OpenApplyServiceImpl implements OpenApplyService {
	@Autowired
	private OpenApplyDao openApplyDao;
	
	@Override
	public OpenApplyEntity queryObject(Long openApplyId){
		return openApplyDao.queryObject(openApplyId);
	}
	
	@Override
	public List<OpenApplyEntity> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return openApplyDao.queryList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return openApplyDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody  OpenApplyEntity openApply){
		openApplyDao.save(openApply);
	}
	
	@Override
	public void update(@RequestBody OpenApplyEntity openApply){
		openApplyDao.update(openApply);
	}
	
	@Override
	public void delete(Long openApplyId){
		openApplyDao.delete(openApplyId);
	}
	
	@Override
	public void deleteBatch(Long[] openApplyIds){
		openApplyDao.deleteBatch(openApplyIds);
	}

	public OpenApplyEntity queryByMobile(String mobile) {
		return openApplyDao.queryByMobile(mobile);
	}

}
