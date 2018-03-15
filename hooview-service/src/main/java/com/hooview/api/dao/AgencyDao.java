package com.hooview.api.dao;

import com.hooview.api.entity.AgencyEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 机构信息表
 *
 * @author lee
 * @email
 * @date 2018-02-07 17:18:52
 */
@Mapper
public interface AgencyDao extends BaseDao<AgencyEntity> {

    void deleteAgency(Map<String,Object> map);
}
