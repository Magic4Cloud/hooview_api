package com.hooview.api.service;

import com.hooview.api.entity.UuidEntity;
import com.hooview.api.service.impl.UuidServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = UuidServiceBack.class)
public interface UuidService {

	@RequestMapping(value="/uuid/queryObject",method = RequestMethod.GET)
	UuidEntity queryObject(@RequestParam("uuid") String uuid);

	@RequestMapping(value="/uuid/save",method = RequestMethod.POST)
	void save(UuidEntity uuid);

	@RequestMapping(value="/uuid/delete",method = RequestMethod.POST)
	void delete(String uuid);
}
