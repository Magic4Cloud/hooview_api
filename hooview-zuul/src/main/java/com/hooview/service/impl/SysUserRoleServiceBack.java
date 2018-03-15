package com.hooview.service.impl;

import com.hooview.service.SysUserRoleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时48分
 * @discription
 */
@Component
public class SysUserRoleServiceBack implements SysUserRoleService{
    @Override
    public void saveOrUpdate(Map<String, Object> map) {

    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return null;
    }

    @Override
    public void delete(Long userId) {

    }
}
