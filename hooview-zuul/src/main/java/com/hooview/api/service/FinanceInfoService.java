package com.hooview.api.service;

import com.hooview.api.dto.*;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.service.impl.FinanceInfoServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = FinanceInfoServiceBack.class)
public interface FinanceInfoService {

	@RequestMapping(value="/financeInfo/queryObject",method = RequestMethod.GET)
	FinanceInfoEntity queryObject(@RequestParam(value = "financeInfoId") Long financeInfoId);

	@RequestMapping(value="/financeInfo/queryList",method = RequestMethod.GET)
	List<FinanceInfoEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/praise",method = RequestMethod.POST)
	void praise(@RequestBody FinanceInfoEntity financeInfoEntity);

	@RequestMapping(value="/financeInfo/save",method = RequestMethod.POST)
	void save(@RequestBody FinanceInfoEntity financeInfo);

	@RequestMapping(value="/financeInfo/update",method = RequestMethod.POST)
	void update(@RequestBody FinanceInfoEntity financeInfo);

	@RequestMapping(value="/financeInfo/delete",method = RequestMethod.POST)
	void delete(Long financeInfoId);

	@RequestMapping(value="/financeInfo/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestBody Map<String,Object> map);

	@RequestMapping(value="/financeInfo/queryFinanceList",method = RequestMethod.GET)
	List<FinanceDTO> queryFinanceList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/queryFinanceTotal",method = RequestMethod.GET)
	int queryFinanceTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/queryAdminFinanceList",method = RequestMethod.GET)
	List<AdminFinanceDTO> queryAdminFinanceList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/queryAdminFinanceTotal",method = RequestMethod.GET)
	int queryAdminFinanceTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/financeInfo/queryFinanceInfo",method = RequestMethod.GET)
	FinanceInfoDTO queryFinanceInfo(@RequestParam("financeInfoId") Long financeInfoId);

	@RequestMapping(value="/financeInfo/queryAdminFinanceInfo",method = RequestMethod.GET)
	AdminFinanceInfoDTO queryAdminFinanceInfo(@RequestParam("financeInfoId") Long financeInfoId);

	@RequestMapping(value="/financeInfo/queryRecommendList",method = RequestMethod.GET)
	List<RecommendDTO> queryRecommendList(@RequestParam("keyword") String keyword);
}
