package com.hooview.service.impl;

import com.hooview.entity.SysMenuEntity;
import com.hooview.service.SysMenuService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时42分
 * @discription
 */
@Component
public class SysMenuServiceBack implements SysMenuService{
    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        return null;
    }


    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return null;
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        return null;
    }

    @Override
    public SysMenuEntity queryObject(Long menuId) {
        return null;
    }

    @Override
    public List<SysMenuEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysMenuEntity menu) {

    }

    @Override
    public void update(SysMenuEntity menu) {

    }

    @Override
    public void deleteBatch(Long[] menuIds) {

    }

    @Override
    public List<SysMenuEntity> queryUserList(Long userId) {
        return null;
    }
}
