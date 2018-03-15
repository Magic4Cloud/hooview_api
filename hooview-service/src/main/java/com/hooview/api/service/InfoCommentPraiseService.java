package com.hooview.api.service;

import com.hooview.api.dao.InfoCommentPraiseDao;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.entity.InfoCommentPraiseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public interface InfoCommentPraiseService {

	@RequestMapping(value="/infoCommentPraise/save",method = RequestMethod.POST)
	void save(@RequestBody InfoCommentPraiseEntity infoCommentPraiseEntity);

	@RequestMapping(value="/infoCommentPraise/queryPraise",method = RequestMethod.GET)
	InfoCommentPraiseEntity queryPraise(@RequestParam("financeInfoId") Long financeInfoId, @RequestParam("userId") Long userId);

	@RequestMapping(value="/infoCommentPraise/deletePraise",method = RequestMethod.POST)
	void deletePraise(@RequestBody InfoCommentPraiseEntity infoCommentPraiseEntity);
}
