package com.hooview.api.service;

import com.hooview.api.dto.orderDTO;
import com.hooview.api.entity.OrderEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface OrderService {

	@RequestMapping(value="/order/queryObject",method = RequestMethod.GET)
	orderDTO queryObject(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/order/queryList",method = RequestMethod.GET)
	List<orderDTO> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/order/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/order/save",method = RequestMethod.POST)
	void save(OrderEntity order);

	@RequestMapping(value="/order/update",method = RequestMethod.POST)
	void update(OrderEntity order);

	@RequestMapping(value="/order/delete",method = RequestMethod.POST)
	void delete(Long orderId);

	@RequestMapping(value="/order/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] orderIds);
}
