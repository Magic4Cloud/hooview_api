package com.hooview.api.service.impl;

import com.hooview.api.dto.orderDTO;
import com.hooview.api.entity.OrderEntity;
import com.hooview.api.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;



@Component
public class OrderServiceBack implements OrderService {

	@Override
	public orderDTO queryObject(Map<String, Object> map){
		return null;
	}
	
	@Override
	public List<orderDTO> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(OrderEntity order){

	}
	
	@Override
	public void update(OrderEntity order){

	}
	
	@Override
	public void delete(Long orderId){

	}
	
	@Override
	public void deleteBatch(Long[] orderIds){

	}
	
}
