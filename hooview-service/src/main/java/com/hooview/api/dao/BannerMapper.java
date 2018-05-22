package com.hooview.api.dao;

import com.hooview.api.entity.Banner;

import java.util.List;
import java.util.Map;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    List<Banner> queryByParams(Map<String, Object> map);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}