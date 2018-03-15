package com.hooview.api.service.impl;

import com.hooview.api.dto.*;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.service.FinanceInfoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class FinanceInfoServiceBack implements FinanceInfoService {

	@Override
	public FinanceInfoEntity queryObject(Long financeInfoId){
		return null;
	}
	
	@Override
	public List<FinanceInfoEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}

	@Override
	public void praise(FinanceInfoEntity financeInfoEntity) {

	}

	@Override
	public void save(FinanceInfoEntity financeInfo){

	}
	
	@Override
	public void update(FinanceInfoEntity financeInfo){

	}
	
	@Override
	public void delete(Long financeInfoId){

	}
	
	@Override
	public void deleteBatch(Map<String,Object> map){

	}

	public List<FinanceDTO> queryFinanceList(Map<String, Object> map) {
		return null;
	}

	public int queryFinanceTotal(Map<String, Object> map) {
		return 0;
	}

	@Override
	public List<AdminFinanceDTO> queryAdminFinanceList(Map<String, Object> map) {
		return null;
	}

	@Override
	public int queryAdminFinanceTotal(Map<String, Object> map) {
		return 0;
	}

	public FinanceInfoDTO queryFinanceInfo(Long financeInfoId) {
		return null;
	}

	@Override
	public AdminFinanceInfoDTO queryAdminFinanceInfo(Long financeInfoId) {
		return null;
	}

	public List<RecommendDTO> queryRecommendList(String keyword) {
		return null;
	}

}
