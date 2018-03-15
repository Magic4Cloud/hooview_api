package com.hooview.api.service.impl;

import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.entity.InfoCommentPraiseEntity;
import com.hooview.api.service.InfoCommentPraiseService;
import org.springframework.stereotype.Component;


@Component
public class InfoCommentPraiseServiceBack implements InfoCommentPraiseService {

	@Override
	public void save(InfoCommentPraiseEntity infoCommentPraiseEntity) {

	}

	@Override
	public InfoCommentPraiseEntity queryPraise(Long financeInfoId, Long userId) {
		return null;
	}

	@Override
	public void deletePraise(InfoCommentPraiseEntity infoCommentPraiseEntity) {

	}
}
