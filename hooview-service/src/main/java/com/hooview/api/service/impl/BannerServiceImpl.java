package com.hooview.api.service.impl;

import com.hooview.api.dao.BannerMapper;
import com.hooview.api.entity.Banner;
import com.hooview.api.service.BannerService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public Banner queryObject(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Banner> queryList(Map<String, Object> map) {
        return bannerMapper.queryByParams(map);
    }


    @Override
    public void save(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }


    @Override
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }
}
