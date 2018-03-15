package com.hooview.api.dao;

import com.hooview.api.dto.orderDTO;
import com.hooview.api.entity.OrderEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {

    orderDTO queryOrderObject(Map<String, Object> map);

    List<orderDTO> queryOrderList(Map<String, Object> map);

	
}
