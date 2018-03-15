package com.hooview.api.service;

import com.hooview.api.entity.AgencyEntity;
import com.hooview.api.service.impl.AgencyServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 机构信息表
 *
 * @author lee
 * @email
 * @date 2018-02-07 17:18:52
 */
@FeignClient(value = "hooview-service",fallback = AgencyServiceBack.class)
public interface AgencyService {

    @RequestMapping(value="/agency/queryObject",method = RequestMethod.GET)
    AgencyEntity queryObject(@RequestParam("agencyId") Long agencyId);

    @RequestMapping(value="/agency/queryList",method = RequestMethod.GET)
    List<AgencyEntity> queryList(@RequestParam Map<String, Object> map);

    @RequestMapping(value="/agency/queryTotal",method = RequestMethod.GET)
    int queryTotal(@RequestParam Map<String, Object> map);

    @RequestMapping(value="/agency/save",method = RequestMethod.POST)
    void save(@RequestBody AgencyEntity agency);

    @RequestMapping(value="/agency/update",method = RequestMethod.POST)
    void update(@RequestBody AgencyEntity agency);

    @RequestMapping(value="/agency/delete",method = RequestMethod.POST)
    void delete(@RequestBody Map<String,Object> map);

    @RequestMapping(value="/agency/deleteBatch",method = RequestMethod.POST)
    void deleteBatch(Long[] ids);
}
