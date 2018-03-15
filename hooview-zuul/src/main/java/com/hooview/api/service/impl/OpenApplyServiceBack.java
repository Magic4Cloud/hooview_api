package com.hooview.api.service.impl;

import com.hooview.api.entity.OpenApplyEntity;
import com.hooview.api.service.OpenApplyService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class OpenApplyServiceBack implements OpenApplyService {

	@Override
	public OpenApplyEntity queryObject(Long openApplyId){
		return null;
	}
	
	@Override
	public List<OpenApplyEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(OpenApplyEntity openApply){

	}
	
	@Override
	public void update(OpenApplyEntity openApply){

	}
	
	@Override
	public void delete(Long openApplyId){

	}
	
	@Override
	public void deleteBatch(Long[] openApplyIds){

	}

	public OpenApplyEntity queryByMobile(String mobile) {
		return null;
	}

}
