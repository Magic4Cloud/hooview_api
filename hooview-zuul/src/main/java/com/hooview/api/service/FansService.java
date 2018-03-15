package com.hooview.api.service;

import com.hooview.api.dto.FansDTO;
import com.hooview.api.entity.FansEntity;
import com.hooview.api.service.impl.FansServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户粉丝表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = FansServiceBack.class)
public interface FansService {

	@RequestMapping(value="/fans/follow",method = RequestMethod.POST)
	void follow(@RequestBody FansEntity user);

	@RequestMapping(value="/fans/deleteFollow",method = RequestMethod.POST)
	void deleteFollow(@RequestBody FansEntity user);

	@RequestMapping(value="/fans/queryObject",method = RequestMethod.GET)
	FansEntity queryObject(Long userId);

	@RequestMapping(value="/fans/getFollow",method = RequestMethod.GET)
	FansEntity getFollow(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/fans/queryList",method = RequestMethod.GET)
	List<FansDTO> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/fans/queryFansList",method = RequestMethod.GET)
	List<FansDTO> queryFansList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/fans/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/fans/queryFansTotal",method = RequestMethod.GET)
	int queryFansTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/fans/save",method = RequestMethod.POST)
	void save(FansEntity fans);

	@RequestMapping(value="/fans/update",method = RequestMethod.POST)
	void update(FansEntity fans);

	@RequestMapping(value="/fans/delete",method = RequestMethod.POST)
	void delete(Long userId);

	@RequestMapping(value="/fans/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] userIds);
}
