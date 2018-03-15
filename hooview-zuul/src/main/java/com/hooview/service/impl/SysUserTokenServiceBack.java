package com.hooview.service.impl;

import com.hooview.entity.SysUserTokenEntity;
import com.hooview.service.SysUserTokenService;
import org.springframework.stereotype.Component;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时51分
 * @discription
 */
@Component
public class SysUserTokenServiceBack implements SysUserTokenService{
    @Override
    public SysUserTokenEntity queryByUserId(Long userId) {
        return null;
    }

    @Override
    public void save(SysUserTokenEntity token) {

    }

    @Override
    public void update(SysUserTokenEntity token) {

    }

    @Override
    public String createToken(Long userId) {
        return null;
    }

    @Override
    public void logout(String token) {

    }

}
