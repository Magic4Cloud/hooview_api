package com.hooview.api.dao;

import com.hooview.api.dto.*;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface FinancePraiseDao extends BaseDao<FinancePraiseEntity> {

    FinancePraiseEntity queryPraise(@Param("financeInfoId") Long financeInfoId,@Param("userId") Long userId);

    void deletePraise(FinancePraiseEntity financePraiseEntity);
}
