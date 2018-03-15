package com.hooview.api.service.impl;

import com.hooview.api.dao.AgreementDao;
import com.hooview.api.entity.AgreementEntity;
import com.hooview.api.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service("agreementService")
public class AgreementServiceImpl implements AgreementService {
	@Autowired
	private AgreementDao agreementDao;


	public void update(@RequestBody AgreementEntity agreement) {
		agreementDao.update(agreement);
	}

	public AgreementEntity queryUserAgreement() {
		return agreementDao.queryUserAgreement();
	}

	public AgreementEntity queryAnchorAgreement() {
		return agreementDao.queryAnchorAgreement();
	}
}
