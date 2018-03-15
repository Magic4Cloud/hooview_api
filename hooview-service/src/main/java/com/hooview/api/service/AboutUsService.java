package com.hooview.api.service;

import com.hooview.api.entity.AboutUsEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface AboutUsService {

	@RequestMapping(value="/aboutUs/queryObject",method = RequestMethod.GET)
	AboutUsEntity queryObject();

	@RequestMapping(value="/aboutUs/update",method = RequestMethod.POST)
	void update(@RequestBody AboutUsEntity aboutUs);

}
