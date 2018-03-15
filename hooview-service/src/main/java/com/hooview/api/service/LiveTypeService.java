package com.hooview.api.service;

import com.hooview.api.entity.LiveTypeEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 直播类型表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public interface LiveTypeService {

	@RequestMapping(value="/liveType/queryObject",method = RequestMethod.GET)
	LiveTypeEntity queryObject(@RequestParam("liveTypeId") Integer liveTypeId);

	@RequestMapping(value="/liveType/queryList")
	List<LiveTypeEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/liveType/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/liveType/save",method = RequestMethod.POST)
	void save(LiveTypeEntity liveType);

	@RequestMapping(value="/liveType/update",method = RequestMethod.POST)
	void update(LiveTypeEntity liveType);

	@RequestMapping(value="/liveType/delete",method = RequestMethod.POST)
	void delete(Integer liveTypeId);

	@RequestMapping(value="/liveType/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Integer[] liveTypeIds);
}
