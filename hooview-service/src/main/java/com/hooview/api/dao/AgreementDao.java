package com.hooview.api.dao;

import com.hooview.api.entity.AgreementEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 协议表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface AgreementDao extends BaseDao<AgreementEntity> {
    AgreementEntity queryUserAgreement();
    AgreementEntity queryAnchorAgreement();
}
