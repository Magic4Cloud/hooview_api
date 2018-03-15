package com.hooview.api.service.impl;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import com.hooview.api.entity.AgencyEntity;
import com.hooview.api.service.AgencyService;
import org.springframework.web.bind.annotation.RequestBody;


@Component
public class AgencyServiceBack implements AgencyService {

    @Override
    public AgencyEntity queryObject(Long id){
        return null;
    }

    @Override
    public List<AgencyEntity> queryList(Map<String, Object> map){
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return 0;
    }

    @Override
    public void save(AgencyEntity agency){

    }

    @Override
    public void update(AgencyEntity agency){

    }

    @Override
    public void delete(@RequestBody Map<String,Object> map){

    }

    @Override
    public void deleteBatch(Long[] ids){

    }

}
