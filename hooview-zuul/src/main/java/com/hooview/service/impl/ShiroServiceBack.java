package com.hooview.service.impl;

import com.hooview.entity.SysUserEntity;
import com.hooview.entity.SysUserTokenEntity;
import com.hooview.service.ShiroService;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时27分
 * @discription
 */
@Component
public class ShiroServiceBack implements ShiroService{
    @Override
    public Set<String> getUserPermissions(long userId) {
        return null;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return null;
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return null;
    }
}
