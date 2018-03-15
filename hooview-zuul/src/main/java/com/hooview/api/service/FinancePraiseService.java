package com.hooview.api.service;

import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.service.impl.FinanceInfoServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@FeignClient(value = "hooview-service",fallback = FinanceInfoServiceBack.class)
public interface FinancePraiseService {

	@RequestMapping(value="/financePraise/save",method = RequestMethod.POST)
	void save(@RequestBody FinancePraiseEntity financeInfo);

	@RequestMapping(value="/financePraise/queryPraise",method = RequestMethod.GET)
	FinancePraiseEntity queryPraise(@RequestParam("financeInfoId") Long financeInfoId, @RequestParam("userId") Long userId);

	@RequestMapping(value="/financePraise/deletePraise",method = RequestMethod.POST)
	void deletePraise(@RequestBody FinancePraiseEntity financePraiseEntity);
}
