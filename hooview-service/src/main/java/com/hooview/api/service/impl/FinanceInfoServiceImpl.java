package com.hooview.api.service.impl;

import com.hooview.api.dto.*;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.FinanceInfoDao;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.service.FinanceInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;


@Service("financeInfoService")
public class FinanceInfoServiceImpl implements FinanceInfoService {
	@Autowired
	private FinanceInfoDao financeInfoDao;
	
	@Override
	public FinanceInfoEntity queryObject(Long financeInfoId){
		return financeInfoDao.queryObject(financeInfoId);
	}
	
	@Override
	public List<FinanceInfoEntity> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return financeInfoDao.queryList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return financeInfoDao.queryTotal(map);
	}

	@Override
	public List<AdminFinanceDTO> queryAdminFinanceList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return financeInfoDao.queryAdminList(query);
	}

	@Override
	public int queryAdminFinanceTotal(Map<String, Object> map) {
		return financeInfoDao.queryAdminTotal(map);
	}

	@Override
	public AdminFinanceInfoDTO queryAdminFinanceInfo(@RequestParam("financeInfoId") Long financeInfoId) {
		return financeInfoDao.queryAdminFinanceInfo(financeInfoId);
	}

	@Override
	public void praise(@RequestBody FinanceInfoEntity financeInfoEntity) {
		financeInfoDao.praise(financeInfoEntity);
	}

	@Override
	public void save(@RequestBody FinanceInfoEntity financeInfo){
		financeInfoDao.save(financeInfo);
	}
	
	@Override
	public void update(@RequestBody FinanceInfoEntity financeInfo){
		financeInfoDao.update(financeInfo);
	}
	
	@Override
	public void delete(Long financeInfoId){
		financeInfoDao.delete(financeInfoId);
	}
	
	@Override
	public void deleteBatch(@RequestBody Map<String,Object> map){
		financeInfoDao.deleteBatch(map);
	}

	public List<FinanceDTO> queryFinanceList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return financeInfoDao.queryFinanceList(query);
	}

	public int queryFinanceTotal(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return financeInfoDao.queryFinanceTotal(query);
	}

	public FinanceInfoDTO queryFinanceInfo(@RequestParam("financeInfoId") Long financeInfoId) {
		return financeInfoDao.queryFinanceInfo(financeInfoId);
	}

	public List<RecommendDTO> queryRecommendList(@RequestParam("keyword") String keyword) {
		return financeInfoDao.queryRecommendList(keyword);
	}

}
