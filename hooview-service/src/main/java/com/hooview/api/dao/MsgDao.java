package com.hooview.api.dao;

import com.hooview.api.dto.MsgDTO;
import com.hooview.api.entity.MsgEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 消息表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface MsgDao extends BaseDao<MsgEntity> {

    List<MsgDTO> queryMyList(Map<String, Object> map);

    int queryMyTotal(Map<String, Object> map);

    int deleteMyBatch(MsgEntity msgEntity);

}
