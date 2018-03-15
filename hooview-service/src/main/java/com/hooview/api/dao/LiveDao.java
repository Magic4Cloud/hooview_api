package com.hooview.api.dao;

import com.hooview.api.dto.LiveDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.entity.LiveEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 直播表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface LiveDao extends BaseDao<LiveEntity> {

    //查询直播间信息
    LiveEntity queryByVid(String vid);

    List<LiveDTO> adminList(Map<String,Object> map);

    LiveInfoDTO queryadminObject(Object id);

    int queryAdminTotal(Map<String, Object> map);

    int deleteAdminBatch(Map<String, Object> map);

    Long queryLiveId(String vid);

    List<Long> queryByKeyword(@Param("keyword") String keyord);
}
