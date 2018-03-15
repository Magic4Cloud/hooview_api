package com.hooview.api.service;

import com.hooview.api.dto.FinanceCollectionDTO;
import com.hooview.api.dto.LiveCollectionDTO;
import com.hooview.api.entity.CollectionEntity;
import com.hooview.api.service.impl.CollectionServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = CollectionServiceBack.class)
public interface CollectionService {

	@RequestMapping(value="/collection/queryFinanceList",method = RequestMethod.GET)
	List<FinanceCollectionDTO> queryFinanceList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/collection/queryFinanceTotal",method = RequestMethod.GET)
	int queryFinanceTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/collection/queryObject",method = RequestMethod.GET)
	CollectionEntity queryObject(Long collectionId);

	@RequestMapping(value="/collection/queryList",method = RequestMethod.GET)
	List<LiveCollectionDTO> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/collection/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/collection/save",method = RequestMethod.POST)
	void save(@RequestBody CollectionEntity collection);

	@RequestMapping(value="/collection/update",method = RequestMethod.POST)
	void update(CollectionEntity collection);

	@RequestMapping(value="/collection/delete",method = RequestMethod.POST)
	void delete(@RequestBody Map<String,Object> map);

	@RequestMapping(value="/collection/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Map<String,Object> map);

	@RequestMapping(value="/collection/queryUserFollow",method = RequestMethod.GET)
	Long queryUserFollow(@RequestParam("sourceId") Long sourceId,@RequestParam("userId") Long userId,@RequestParam("type") int type);

	@RequestMapping(value="/collection/deleteSource",method = RequestMethod.POST)
	void deleteSource(@RequestBody Map<String,Object> map);
}
