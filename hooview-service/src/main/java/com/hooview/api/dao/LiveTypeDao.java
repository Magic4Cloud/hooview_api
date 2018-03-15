package com.hooview.api.dao;

import com.hooview.api.entity.LiveTypeEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 直播类型表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface LiveTypeDao extends BaseDao<LiveTypeEntity> {
	
}
