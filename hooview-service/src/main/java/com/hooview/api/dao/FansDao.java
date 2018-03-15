package com.hooview.api.dao;

import com.hooview.api.dto.FansDTO;
import com.hooview.api.entity.FansEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户粉丝表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface FansDao extends BaseDao<FansEntity> {

    List<FansDTO> queryFollowList(Map<String, Object> map);

    List<FansDTO> queryFansList(Map<String, Object> map);

    int queryFansTotal(Map<String, Object> map);

    void follow(FansEntity user);

    void deleteFollow(FansEntity user);

    int followEach(FansEntity user);

    int followed(FansEntity user);

    void updateMutual(FansEntity user);

    FansEntity getFollow(Map<String, Object> map);

}
