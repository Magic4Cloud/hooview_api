package com.hooview.api.dao;

import com.hooview.api.entity.UuidEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface UuidDao extends BaseDao<UuidEntity> {


}