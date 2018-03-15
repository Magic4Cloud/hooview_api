package com.hooview.api.service.impl;

import com.hooview.api.dao.FinancePraiseDao;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.service.FinancePraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service("financePraiseService")
public class FinancePraiseServiceImpl implements FinancePraiseService {

	@Autowired
	private FinancePraiseDao financePraiseDao;

	public void save(@RequestBody  FinancePraiseEntity financeInfo) {
		financePraiseDao.save(financeInfo);
	}

	@Override
	public FinancePraiseEntity queryPraise(Long financeInfoId, Long userId) {
		return financePraiseDao.queryPraise(financeInfoId,userId);
	}

	@Override
	public void deletePraise(@RequestBody FinancePraiseEntity financePraiseEntity) {
		financePraiseDao.deletePraise(financePraiseEntity);
	}
}
