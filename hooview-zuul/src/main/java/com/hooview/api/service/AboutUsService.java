package com.hooview.api.service;

import com.hooview.api.entity.AboutUsEntity;
import com.hooview.api.service.impl.AboutUsServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 关于表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = AboutUsServiceBack.class)
public interface AboutUsService {

	@RequestMapping(value="/aboutUs/queryObject",method = RequestMethod.GET)
	AboutUsEntity queryObject();

	@RequestMapping(value="/aboutUs/update",method = RequestMethod.POST)
	void update(@RequestBody AboutUsEntity aboutUs);

}
