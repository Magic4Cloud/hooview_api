package com.hooview.service.impl;

import com.hooview.api.dto.AnchorDTO;
import com.hooview.api.dto.AnchorUserDTO;
import com.hooview.api.dto.ApplyAnchorDTO;
import com.hooview.api.dto.UserDTO;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysUserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时23分
 * @discription
 */
@Component
public class SysUserServiceBack implements SysUserService{
    @Override
    public List<String> queryAllPerms(Long userId) {
        return null;
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    public SysUserEntity queryByUserName(String username) {
        return null;
    }

    @Override
    public SysUserEntity queryObject(Long userId) {
        return null;
    }

    @Override
    public List<AnchorUserDTO> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<ApplyAnchorDTO> queryApplyAnchorList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryApplyAnchorTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysUserEntity user) {

    }

    @Override
    public void update(SysUserEntity user) {

    }

    @Override
    public void applyAnchor(ApplyAnchorDTO user) {

    }

    @Override
    public void auditApplyAnchor(SysUserEntity user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public int updatePassword( String phone, String newPassword) {
        return 0;
    }

    @Override
    public SysUserEntity queryByMobile(String mobile) {
        return null;
    }

    public List<AnchorDTO> queryAnchorList(String username) {
        return null;
    }

    public UserDTO queryByYiId(String yiId) {
        return null;
    }

    @Override
    public Long queryAgencyId(Long userId) {
        return null;
    }
}
