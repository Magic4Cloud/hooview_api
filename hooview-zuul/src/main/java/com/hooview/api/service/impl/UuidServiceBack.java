package com.hooview.api.service.impl;

import com.hooview.api.entity.UuidEntity;
import com.hooview.api.service.UuidService;
import org.springframework.stereotype.Component;

@Component
public class UuidServiceBack implements UuidService{
    @Override
    public UuidEntity queryObject(String uuid) {
        return null;
    }

    @Override
    public void save(UuidEntity uuid) {

    }

    @Override
    public void delete(String uuid) {

    }
}
