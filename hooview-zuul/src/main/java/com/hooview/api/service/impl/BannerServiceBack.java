package com.hooview.api.service.impl;

import com.hooview.api.entity.Banner;
import com.hooview.api.service.BannerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class BannerServiceBack implements BannerService {

	@Override
	public Banner queryObject(Integer id){
		return null;
	}
	
	@Override
	public List<Banner> queryList(Map<String, Object> map){
		return null;
	}

	
	@Override
	public void save(Banner banner){

	}
	
	@Override
	public void update(Banner banner){

	}


	@Override
	public void delete(Integer id){

	}

	
}
