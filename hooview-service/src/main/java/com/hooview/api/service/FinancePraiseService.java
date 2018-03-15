package com.hooview.api.service;

import com.hooview.api.dto.*;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.FinancePraiseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public interface FinancePraiseService {

	@RequestMapping(value="/financePraise/save",method = RequestMethod.POST)
	void save(@RequestBody FinancePraiseEntity financePraiseEntity);

	@RequestMapping(value="/financePraise/queryPraise",method = RequestMethod.GET)
	FinancePraiseEntity queryPraise(@RequestParam("financeInfoId") Long financeInfoId, @RequestParam("userId") Long userId);

	@RequestMapping(value="/financePraise/deletePraise",method = RequestMethod.POST)
	void deletePraise(@RequestBody FinancePraiseEntity financePraiseEntity);
}
