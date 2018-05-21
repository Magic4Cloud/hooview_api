package com.hooview.dao;

import com.hooview.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 用户表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);
    /**
     * 查询用户所有角色
     * @param userId
     * @return
     */
    List<Long> queryAllRoles(Long userId);
    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    SysUserEntity queryByMobile(String mobile);

    /**
     * 修改密码
     */
    int updatePassword(Map<String, Object> map);


    int queryApplyAnchorTotal(Map<String, Object> map);

    /**
     * 增加/减少关注人数
     */
    void addFollow(Map<String, Object> map);

    /**
     * 增加/减少粉丝人数
     */
    void addFans(Map<String, Object> map);

    /**
     * 审核主播申请
     */
    void auditApplyAnchor(SysUserEntity user);



    Long queryAgencyId(Long userId);
}
