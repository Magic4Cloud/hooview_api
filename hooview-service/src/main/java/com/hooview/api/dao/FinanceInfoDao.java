package com.hooview.api.dao;

import com.hooview.api.dto.*;
import com.hooview.api.entity.FinanceInfoEntity;
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
public interface FinanceInfoDao extends BaseDao<FinanceInfoEntity> {

    void praise(FinanceInfoEntity financeInfoEntity);

    List<FinanceDTO> queryFinanceList(Map<String, Object> map);

    int queryFinanceTotal(Map<String, Object> map);

    FinanceInfoDTO queryFinanceInfo(Long id);

    List<RecommendDTO> queryRecommendList(@Param(value="keyword") String keyword);

    List<AdminFinanceDTO> queryAdminList(Map<String, Object> map);

    int queryAdminTotal(Map<String, Object> map);

    AdminFinanceInfoDTO queryAdminFinanceInfo(Long financeInfoId);
}
