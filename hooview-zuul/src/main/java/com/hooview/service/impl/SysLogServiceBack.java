package com.hooview.service.impl;

import com.hooview.entity.SysLogEntity;
import com.hooview.service.SysLogService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 10时24分
 * @discription
 */
@Component
public class SysLogServiceBack implements SysLogService{
    @Override
    public SysLogEntity queryObject(Long id) {
        return null;
    }

    @Override
    public List<SysLogEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysLogEntity sysLog) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
