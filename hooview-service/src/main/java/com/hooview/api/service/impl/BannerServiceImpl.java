package com.hooview.api.service.impl;

import com.hooview.api.dao.BannerDao;
import com.hooview.api.dto.BannerDTO;
import com.hooview.api.entity.BannerEntity;
import com.hooview.api.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public BannerEntity queryObject(Long id){
		return bannerDao.queryObject(id);
	}
	
	@Override
	public List<BannerEntity> queryList(@RequestParam Map<String, Object> map){
		return bannerDao.queryList(map);
	}

	@Override
	public List<BannerDTO> queryAdminList(@RequestParam Map<String, Object> map) {
		return bannerDao.queryAdminList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return bannerDao.queryTotal(map);
	}

	@Override
	public void bannerOrder(@RequestBody BannerDTO banner) {
		bannerDao.bannerOrder(banner);
	}

	@Override
	public void save(BannerEntity banner){
		bannerDao.save(banner);
	}
	
	@Override
	public void update(@RequestBody BannerDTO banner){
		String url = banner.getPicUrl();
		if(url != null){
			url = url.replaceAll("&amp;","&");
			banner.setPicUrl(url);
		}
		bannerDao.saveOrUpdate(banner);
	}
	
	@Override
	public void delete(Long id){
		bannerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(@RequestBody Map<String, Object> map){
		bannerDao.deleteBatch(map);
	}
	
}
