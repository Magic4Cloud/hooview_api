package com.hooview.api.service;

import com.hooview.api.dto.LiveDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.entity.LiveEntity;
import com.hooview.api.service.impl.LiveServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 直播表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = LiveServiceBack.class)
public interface LiveService {

	@RequestMapping(value="/live/queryObject",method = RequestMethod.GET)
	LiveInfoDTO queryObject(@RequestParam("liveId") Long liveId);

	@RequestMapping(value="/live/queryList",method = RequestMethod.GET)
	List<LiveEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/live/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/live/save",method = RequestMethod.POST)
	void save(@RequestBody LiveEntity live);

	@RequestMapping(value="/live/update",method = RequestMethod.POST)
	void update(@RequestBody LiveEntity live);

	@RequestMapping(value="/live/delete",method = RequestMethod.POST)
	void delete(Long liveId);

	@RequestMapping(value="/live/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Map<String, Object> map);

	@RequestMapping(value="/live/queryByVid",method = RequestMethod.GET)
	LiveEntity queryByVid(@RequestParam("vid") String vid);

	@RequestMapping(value = "/live/admin",method = RequestMethod.GET)
	List<LiveDTO> adminList(@RequestParam Map<String,Object> map);

	@RequestMapping(value="/live/queryAdminTotal",method = RequestMethod.GET)
	int queryAdminTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/live/queryLiveId",method = RequestMethod.GET)
	Long queryLiveId(@RequestParam("vid") String vid);

	@RequestMapping(value="/live/queryByKeyword",method = RequestMethod.GET)
	List<Long> queryByKeyword(@RequestParam("keyord") String keyord);

}