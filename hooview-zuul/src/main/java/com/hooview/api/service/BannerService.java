package com.hooview.api.service;

import com.hooview.api.dto.BannerDTO;
import com.hooview.api.entity.BannerEntity;
import com.hooview.api.service.impl.BannerServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 轮播图表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = BannerServiceBack.class)
public interface BannerService {

	@RequestMapping(value="/banner/queryObject",method = RequestMethod.GET)
	BannerEntity queryObject(Long id);

	@RequestMapping(value="/banner/queryList",method = RequestMethod.GET)
	List<BannerEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/banner/queryAdminList",method = RequestMethod.GET)
	List<BannerDTO> queryAdminList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/banner/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/banner/save",method = RequestMethod.POST)
	void save(BannerEntity banner);

	@RequestMapping(value="/banner/update",method = RequestMethod.POST)
	void update(@RequestBody BannerDTO banner);

	@RequestMapping(value="/banner/order",method = RequestMethod.POST)
	void bannerOrder(@RequestBody BannerDTO banner);

	@RequestMapping(value="/banner/delete",method = RequestMethod.POST)
	void delete(Long id);

	@RequestMapping(value="/banner/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Map<String, Object> map);
}
