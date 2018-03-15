package com.hooview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.AboutUsDao;
import com.hooview.api.entity.AboutUsEntity;
import com.hooview.api.service.AboutUsService;
import org.springframework.web.bind.annotation.RequestBody;


@Service("aboutUsService")
public class AboutUsServiceImpl implements AboutUsService {
	@Autowired
	private AboutUsDao aboutUsDao;
	
	@Override
	public AboutUsEntity queryObject(){
		return aboutUsDao.queryObject(null);
	}

	@Override
	public void update(@RequestBody AboutUsEntity aboutUs){
		aboutUsDao.update(aboutUs);
	}

	
}
