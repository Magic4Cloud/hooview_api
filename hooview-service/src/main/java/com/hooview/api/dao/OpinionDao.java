package com.hooview.api.dao;

import com.hooview.api.dto.OpinionDTO;
import com.hooview.api.entity.OpinionEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 意见反馈表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface OpinionDao extends BaseDao<OpinionEntity> {

    List<OpinionDTO> queryByList(Map<String, Object> map);
	
}
