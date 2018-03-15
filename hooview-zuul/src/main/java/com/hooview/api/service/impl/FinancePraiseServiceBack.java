package com.hooview.api.service.impl;

import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.service.FinancePraiseService;
import org.springframework.stereotype.Component;



@Component
public class FinancePraiseServiceBack implements FinancePraiseService {


	@Override
	public void save(FinancePraiseEntity financePraiseEntity) {

	}

	@Override
	public FinancePraiseEntity queryPraise(Long financeInfoId, Long userId) {
		return null;
	}

	@Override
	public void deletePraise(FinancePraiseEntity financePraiseEntity) {

	}
}
