package com.hooview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.PayTypeDao;
import com.hooview.api.entity.PayTypeEntity;
import com.hooview.api.service.PayTypeService;



@Service("payTypeService")
public class PayTypeServiceImpl implements PayTypeService {
	@Autowired
	private PayTypeDao payTypeDao;
	
	@Override
	public PayTypeEntity queryObject(Integer payTypeId){
		return payTypeDao.queryObject(payTypeId);
	}
	
	@Override
	public List<PayTypeEntity> queryList(Map<String, Object> map){
		return payTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return payTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(PayTypeEntity payType){
		payTypeDao.save(payType);
	}
	
	@Override
	public void update(PayTypeEntity payType){
		payTypeDao.update(payType);
	}
	
	@Override
	public void delete(Integer payTypeId){
		payTypeDao.delete(payTypeId);
	}
	
	@Override
	public void deleteBatch(Integer[] payTypeIds){
		payTypeDao.deleteBatch(payTypeIds);
	}
	
}
