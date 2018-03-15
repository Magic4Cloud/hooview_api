package com.hooview.service.impl;

import com.hooview.api.dto.SelectRoleDTO;
import com.hooview.entity.SysRoleEntity;
import com.hooview.service.SysRoleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时46分
 * @discription
 */
@Component
public class SysRoleServiceBack implements SysRoleService{
    @Override
    public SysRoleEntity queryObject(Long roleId) {
        return null;
    }

    @Override
    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysRoleEntity role) {

    }

    @Override
    public void update(SysRoleEntity role) {

    }

    @Override
    public void deleteBatch(Long[] roleIds) {

    }

    @Override
    public List<SelectRoleDTO> queryRoleIdList() {
        return null;
    }
}
