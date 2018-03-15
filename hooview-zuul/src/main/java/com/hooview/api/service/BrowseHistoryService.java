package com.hooview.api.service;

import com.hooview.api.dto.HistoryDTO;
import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.service.impl.BrowseHistoryServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户浏览历史表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = BrowseHistoryServiceBack.class)
public interface BrowseHistoryService {

	@RequestMapping(value="/browseHistory/queryObject",method = RequestMethod.GET)
	BrowseHistoryEntity queryObject(Long browseHistoryId);

	@RequestMapping(value="/browseHistory/queryList",method = RequestMethod.GET)
	List<HistoryDTO> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/browseHistory/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/browseHistory/save",method = RequestMethod.POST)
	void save(BrowseHistoryEntity browseHistory);

	@RequestMapping(value="/browseHistory/update",method = RequestMethod.POST)
	void update(BrowseHistoryEntity browseHistory);

	@RequestMapping(value="/browseHistory/delete",method = RequestMethod.POST)
	void delete(Long browseHistoryId);

	@RequestMapping(value="/browseHistory/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody BrowseHistoryEntity browseHistory);

	@RequestMapping(value="/browseHistory/deleteSource",method = RequestMethod.POST)
	void deleteSource(@RequestBody Map<String,Object> map);
}
