package com.hooview.api.service;

import com.hooview.api.entity.LiveTypeEntity;
import com.hooview.api.service.impl.LiveTypeServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 直播类型表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = LiveTypeServiceBack.class)
public interface LiveTypeService {

	@RequestMapping(value="/liveType/queryObject",method = RequestMethod.GET)
	LiveTypeEntity queryObject(@RequestParam("liveTypeId")Integer liveTypeId);

	@RequestMapping(value="/liveType/queryList",method = RequestMethod.GET)
	List<LiveTypeEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/liveType/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/liveType/save",method = RequestMethod.POST)
	void save(LiveTypeEntity liveType);

	@RequestMapping(value="/liveType/update",method = RequestMethod.POST)
	void update(LiveTypeEntity liveType);

	@RequestMapping(value="/liveType/delete",method = RequestMethod.POST)
	void delete(Integer liveTypeId);

	@RequestMapping(value="/liveType/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Integer[] liveTypeIds);
}
