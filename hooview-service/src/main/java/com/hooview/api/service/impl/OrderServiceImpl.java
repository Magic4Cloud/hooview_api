package com.hooview.api.service.impl;

import com.hooview.api.dto.orderDTO;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.OrderDao;
import com.hooview.api.entity.OrderEntity;
import com.hooview.api.service.OrderService;
import org.springframework.web.bind.annotation.RequestParam;


@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public orderDTO queryObject(@RequestParam Map<String, Object> map){
		return orderDao.queryOrderObject(map);
	}
	
	@Override
	public List<orderDTO> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return orderDao.queryOrderList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
	}
	
	@Override
	public void delete(Long orderId){
		orderDao.delete(orderId);
	}
	
	@Override
	public void deleteBatch(Long[] orderIds){
		orderDao.deleteBatch(orderIds);
	}
	
}
