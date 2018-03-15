package com.hooview.service.impl;

import com.hooview.service.SysRoleMenuService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时45分
 * @discription
 */
@Component
public class SysRoleMenuServiceBack implements SysRoleMenuService{
    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {

    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return null;
    }
}
