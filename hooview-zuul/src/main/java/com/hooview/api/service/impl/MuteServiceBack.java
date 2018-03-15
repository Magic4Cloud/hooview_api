package com.hooview.api.service.impl;

import com.hooview.api.dto.MuteCharMembers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.entity.MuteEntity;
import com.hooview.api.service.MuteService;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class MuteServiceBack implements MuteService {

    @Override
    public MuteEntity queryObject(Long id){
        return null;
    }

    @Override
    public List<MuteEntity> queryMuteList(Map<String, Object> map){
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return 0;
    }

    @Override
    public void save(MuteEntity mute){

    }

    @Override
    public void saveBatch(MuteCharMembers mute) {

    }

    @Override
    public void update(MuteEntity mute){

    }

    @Override
    public void delete(Map<String, Object> map){

    }

    @Override
    public void deleteBatch(Long[] ids){

    }

}
