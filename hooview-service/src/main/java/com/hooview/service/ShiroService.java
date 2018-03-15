package com.hooview.service;

import com.hooview.entity.SysUserEntity;
import com.hooview.entity.SysUserTokenEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * shiro相关接口
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-06 8:49
 */
@RestController
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    @RequestMapping(value = "/shiro/queryAllPerms",method = RequestMethod.GET)
    Set<String> getUserPermissions(long userId);

    @RequestMapping(value = "/queryByToken",method = RequestMethod.GET)
    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    @RequestMapping(value = "/queryUser",method = RequestMethod.GET)
    SysUserEntity queryUser(Long userId);
}
