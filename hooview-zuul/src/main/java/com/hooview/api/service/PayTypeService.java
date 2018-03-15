package com.hooview.api.service;

import com.hooview.api.entity.PayTypeEntity;
import com.hooview.api.service.impl.PayTypeServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 支付方式表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = PayTypeServiceBack.class)
public interface PayTypeService {

	@RequestMapping(value="/payType/queryObject",method = RequestMethod.GET)
	PayTypeEntity queryObject(Integer payTypeId);

	@RequestMapping(value="/payType/queryList",method = RequestMethod.GET)
	List<PayTypeEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/payType/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/payType/save",method = RequestMethod.POST)
	void save(PayTypeEntity payType);

	@RequestMapping(value="/payType/update",method = RequestMethod.POST)
	void update(PayTypeEntity payType);

	@RequestMapping(value="/payType/delete",method = RequestMethod.POST)
	void delete(Integer payTypeId);

	@RequestMapping(value="/payType/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Integer[] payTypeIds);
}
