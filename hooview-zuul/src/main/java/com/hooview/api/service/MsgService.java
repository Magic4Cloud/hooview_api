package com.hooview.api.service;

import com.hooview.api.dto.MsgDTO;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.impl.MsgServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 消息表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = MsgServiceBack.class)
public interface MsgService {

	@RequestMapping(value="/msg/queryObject",method = RequestMethod.GET)
	MsgEntity queryObject(Long msgId);

	@RequestMapping(value="/msg/queryList",method = RequestMethod.GET)
	List<MsgEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/msg/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/msg/save",method = RequestMethod.POST)
	void save(@RequestBody MsgEntity msg);

	@RequestMapping(value="/msg/update",method = RequestMethod.POST)
	void update(MsgEntity msg);

	@RequestMapping(value="/msg/delete",method = RequestMethod.POST)
	void delete(Long msgId);

	@RequestMapping(value="/msg/queryMyList",method = RequestMethod.POST)
	void deleteBatch(Long[] msgIds);

	@RequestMapping(value="/msg/queryMyList",method = RequestMethod.GET)
	List<MsgDTO> queryMyList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/msg/queryMyTotal",method = RequestMethod.GET)
	int queryMyTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/msg/deleteMyBatch",method = RequestMethod.POST)
	int deleteMyBatch(@RequestBody MsgEntity msgEntity);
}
