package com.hooview.api.service;

import com.hooview.api.entity.Banner;

import java.util.List;
import java.util.Map;

public interface BannerService {
    Banner queryObject(Integer id);

    List<Banner> queryList(Map<String, Object> map);

    void save(Banner banner);

    void update(Banner banner);

    void delete(Integer id);
}
