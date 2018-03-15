package com.hooview.api.service.impl;

import com.hooview.api.dao.AgencyDao;
import com.hooview.api.entity.AgencyEntity;
import com.hooview.api.service.AgencyService;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("agencyService")
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    AgencyDao agencyDao;
    @Override
    public AgencyEntity queryObject(@RequestParam Long agencyId) {
        return agencyDao.queryObject(agencyId);
    }

    @Override
    public List<AgencyEntity> queryList(@RequestParam Map<String, Object> map) {
        Query query = new Query(map);
        return agencyDao.queryList(query);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return agencyDao.queryTotal(map);
    }

    @Override
    public void save(@RequestBody AgencyEntity agency) {
        agencyDao.save(agency);
    }

    @Override
    public void update(@RequestBody AgencyEntity agency) {
        agencyDao.update(agency);
    }

    @Override
    public void delete(@RequestBody Map<String,Object> map) {
        agencyDao.deleteAgency(map);
    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
