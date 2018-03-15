package com.hooview.api.service.impl;

import com.hooview.api.entity.PayTypeEntity;
import com.hooview.api.service.PayTypeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class PayTypeServiceBack implements PayTypeService {

	@Override
	public PayTypeEntity queryObject(Integer payTypeId){
		return null;
	}
	
	@Override
	public List<PayTypeEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(PayTypeEntity payType){

	}
	
	@Override
	public void update(PayTypeEntity payType){

	}
	
	@Override
	public void delete(Integer payTypeId){

	}
	
	@Override
	public void deleteBatch(Integer[] payTypeIds){

	}
	
}
