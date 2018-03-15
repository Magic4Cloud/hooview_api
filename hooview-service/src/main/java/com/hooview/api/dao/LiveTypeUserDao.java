package com.hooview.api.dao;

import com.hooview.api.entity.LiveTypeUserEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 主播所属直播类型表
 *
 * @author lee
 * @email
 * @date 2018-02-09 16:48:41
 */
@Mapper
public interface LiveTypeUserDao extends BaseDao<LiveTypeUserEntity> {

}
