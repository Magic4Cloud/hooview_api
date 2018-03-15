package com.hooview.api.service;

import com.hooview.api.entity.RemindEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 直播提醒表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface RemindService {

	@RequestMapping(value="/remind/queryObject",method = RequestMethod.GET)
	RemindEntity queryObject(Long liveId);

	@RequestMapping(value="/remind/queryList",method = RequestMethod.GET)
	List<RemindEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/remind/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/remind/save",method = RequestMethod.POST)
	void save(RemindEntity remind);

	@RequestMapping(value="/remind/update",method = RequestMethod.POST)
	void update(RemindEntity remind);

	@RequestMapping(value="/remind/delete",method = RequestMethod.POST)
	void delete(Long liveId);

	@RequestMapping(value="/remind/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] liveIds);
}
