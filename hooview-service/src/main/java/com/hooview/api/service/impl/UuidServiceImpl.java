package com.hooview.api.service.impl;

import com.hooview.api.dao.UuidDao;
import com.hooview.api.entity.UuidEntity;
import com.hooview.api.service.UuidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service("uuidService")
public class UuidServiceImpl implements UuidService{

    @Autowired
    UuidDao uuidDao;
    @Override
    public UuidEntity queryObject(String uuid) {
        return uuidDao.queryObject(uuid);
    }

    @Override
    public void save(@RequestBody UuidEntity uuid) {
        uuidDao.save(uuid);
    }

    @Override
    public void delete(String uuid) {
        uuidDao.delete(uuid);
    }
}
