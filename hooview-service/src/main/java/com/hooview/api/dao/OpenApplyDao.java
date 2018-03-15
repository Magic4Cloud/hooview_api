package com.hooview.api.dao;

import com.hooview.api.entity.OpenApplyEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 开户申请表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface OpenApplyDao extends BaseDao<OpenApplyEntity> {

    OpenApplyEntity queryByMobile(String mobile);
}
