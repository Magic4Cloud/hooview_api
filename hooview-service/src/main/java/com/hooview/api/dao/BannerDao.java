package com.hooview.api.dao;

import com.hooview.api.dto.BannerDTO;
import com.hooview.api.entity.BannerEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 轮播图表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface BannerDao extends BaseDao<BannerEntity> {
    List<BannerDTO> queryAdminList(Map<String, Object> map);
    void saveOrUpdate(BannerDTO bannerDTO);
    void bannerOrder(BannerDTO banner);

}
