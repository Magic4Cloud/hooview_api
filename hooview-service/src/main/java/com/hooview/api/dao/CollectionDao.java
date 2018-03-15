package com.hooview.api.dao;

import com.hooview.api.dto.FinanceCollectionDTO;
import com.hooview.api.dto.LiveCollectionDTO;
import com.hooview.api.entity.CollectionEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface CollectionDao extends BaseDao<CollectionEntity> {

    void deleteCollections(Map<String,Object> map);

    List<FinanceCollectionDTO> queryFinanceList(Map<String, Object> map);

    int queryFinanceTotal(Map<String, Object> map);

    List<LiveCollectionDTO> queryLiveList(Map<String, Object> map);

    Long queryUserFollow(@Param("sourceId") Long sourceId, @Param("userId") Long userId, @Param("type") int type);

    void deleteSource(Map<String,Object> map);
}
