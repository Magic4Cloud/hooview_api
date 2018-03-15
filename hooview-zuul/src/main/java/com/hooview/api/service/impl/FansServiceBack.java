package com.hooview.api.service.impl;

import com.hooview.api.dto.FansDTO;
import com.hooview.api.entity.FansEntity;
import com.hooview.api.service.FansService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;



@Component
public class FansServiceBack implements FansService {

	@Override
	public void follow(FansEntity user) {

	}

	@Override
	public void deleteFollow(FansEntity user) {

	}

	@Override
	public FansEntity queryObject(Long userId){
		return null;
	}

	@Override
	public FansEntity getFollow(@RequestParam Map<String, Object> map) {
		return null;
	}

	@Override
	public List<FansDTO> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}

	@Override
	public List<FansDTO> queryFansList(Map<String, Object> map) {
		return null;
	}

	@Override
	public int queryFansTotal(Map<String, Object> map) {
		return 0;
	}

	@Override
	public void save(FansEntity fans){

	}
	
	@Override
	public void update(FansEntity fans){

	}
	
	@Override
	public void delete(Long userId){

	}
	
	@Override
	public void deleteBatch(Long[] userIds){

	}
	
}
