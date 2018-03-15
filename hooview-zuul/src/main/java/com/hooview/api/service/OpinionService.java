package com.hooview.api.service;

import com.hooview.api.dto.OpinionDTO;
import com.hooview.api.entity.OpinionEntity;
import com.hooview.api.service.impl.OpinionServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 意见反馈表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = OpinionServiceBack.class)
public interface OpinionService {

	@RequestMapping(value="/opinion/queryObject",method = RequestMethod.GET)
	OpinionEntity queryObject(Long opinionId);

	@RequestMapping(value="/opinion/queryList",method = RequestMethod.GET)
	List<OpinionEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/opinion/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/opinion/save",method = RequestMethod.POST)
	void save(@RequestBody OpinionEntity opinion);

	@RequestMapping(value="/opinion/update",method = RequestMethod.POST)
	void update(@RequestBody OpinionEntity opinion);

	@RequestMapping(value="/opinion/delete",method = RequestMethod.POST)
	void delete(Long opinionId);

	@RequestMapping(value="/opinion/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] opinionIds);

	@RequestMapping(value="/opinion/queryByList",method = RequestMethod.GET)
	List<OpinionDTO> queryByList(@RequestParam Map<String, Object> map);
}
