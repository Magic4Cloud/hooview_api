package com.hooview.api.service.impl;

import com.hooview.api.dao.InfoCommentPraiseDao;
import com.hooview.api.entity.InfoCommentPraiseEntity;
import com.hooview.api.service.InfoCommentPraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service("infoCommentPraiseService")
public class InfoCommentPraiseServiceImpl implements InfoCommentPraiseService {

	@Autowired
	private InfoCommentPraiseDao infoCommentPraiseDao;

	@Override
	public void save(@RequestBody InfoCommentPraiseEntity infoCommentPraiseEntity) {
		infoCommentPraiseDao.save(infoCommentPraiseEntity);
	}

	@Override
	public InfoCommentPraiseEntity queryPraise(Long financeInfoId, Long userId) {
		return infoCommentPraiseDao.queryPraise(financeInfoId,userId);
	}

	@Override
	public void deletePraise(@RequestBody InfoCommentPraiseEntity infoCommentPraiseEntity) {
		infoCommentPraiseDao.deletePraise(infoCommentPraiseEntity);
	}
}
