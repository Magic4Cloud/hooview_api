package com.hooview.api.service.impl;

import com.hooview.api.dto.BannerDTO;
import com.hooview.api.entity.BannerEntity;
import com.hooview.api.service.BannerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class BannerServiceBack implements BannerService {

	@Override
	public BannerEntity queryObject(Long id){
		return null;
	}
	
	@Override
	public List<BannerEntity> queryList(Map<String, Object> map){
		return null;
	}

	@Override
	public List<BannerDTO> queryAdminList(Map<String, Object> map) {
		return null;
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(BannerEntity banner){

	}
	
	@Override
	public void update(BannerDTO banner){

	}

	@Override
	public void bannerOrder(BannerDTO banner) {

	}

	@Override
	public void delete(Long id){

	}
	
	@Override
	public void deleteBatch(Map<String, Object> map){

	}
	
}
