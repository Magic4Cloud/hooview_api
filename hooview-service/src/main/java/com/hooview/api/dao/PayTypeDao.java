package com.hooview.api.dao;

import com.hooview.api.entity.PayTypeEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付方式表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface PayTypeDao extends BaseDao<PayTypeEntity> {
	
}
