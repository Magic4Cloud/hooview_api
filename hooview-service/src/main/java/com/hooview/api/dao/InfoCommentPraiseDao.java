package com.hooview.api.dao;

import com.hooview.api.entity.FinancePraiseEntity;
import com.hooview.api.entity.InfoCommentPraiseEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface InfoCommentPraiseDao extends BaseDao<InfoCommentPraiseEntity> {

    InfoCommentPraiseEntity queryPraise(@Param("infoCommentId") Long financeInfoId, @Param("userId") Long userId);

    void deletePraise(InfoCommentPraiseEntity infoCommentPraiseEntity);
}
