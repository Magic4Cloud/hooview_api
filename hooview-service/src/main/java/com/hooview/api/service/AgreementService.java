package com.hooview.api.service;

import com.hooview.api.entity.AgreementEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 协议表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface AgreementService {

	@RequestMapping(value="/agreement/update",method = RequestMethod.POST)
	void update(@RequestBody AgreementEntity agreement);

	@RequestMapping(value="/agreement/queryUserAgreement",method = RequestMethod.GET)
	AgreementEntity queryUserAgreement();

	@RequestMapping(value="/agreement/queryAnchorAgreement",method = RequestMethod.GET)
	AgreementEntity queryAnchorAgreement();
}
