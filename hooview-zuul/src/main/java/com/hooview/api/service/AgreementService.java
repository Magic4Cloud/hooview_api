package com.hooview.api.service;

import com.hooview.api.entity.AgreementEntity;
import com.hooview.api.service.impl.AgreementServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 协议表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = AgreementServiceBack.class)
public interface AgreementService {

	@RequestMapping(value="/agreement/queryUserAgreement",method = RequestMethod.GET)
	AgreementEntity queryUserAgreement();

	@RequestMapping(value="/agreement/queryAnchorAgreement",method = RequestMethod.GET)
	AgreementEntity queryAnchorAgreement();

	@RequestMapping(value="/agreement/update",method = RequestMethod.POST)
	void update(@RequestBody AgreementEntity agreement);
}
