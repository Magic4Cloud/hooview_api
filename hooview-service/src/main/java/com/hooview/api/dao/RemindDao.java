package com.hooview.api.dao;

import com.hooview.api.entity.RemindEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 直播提醒表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface RemindDao extends BaseDao<RemindEntity> {
	
}
