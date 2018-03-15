package com.hooview.api.service;

import com.hooview.api.dto.MuteCharMembers;
import com.hooview.api.entity.MuteEntity;
import com.hooview.api.service.impl.MuteServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 禁言列表
 *
 * @author lee
 * @email
 * @date 2018-03-05 09:12:07
 */
@FeignClient(value = "hooview-service",fallback = MuteServiceBack.class)
public interface MuteService {

    @RequestMapping(value="/mute/queryObject",method = RequestMethod.GET)
    MuteEntity queryObject(Long id);

    @RequestMapping(value="/mute/queryMuteList",method = RequestMethod.GET)
    List<MuteEntity> queryMuteList(@RequestParam  Map<String, Object> map);

    @RequestMapping(value="/mute/queryTotal",method = RequestMethod.GET)
    int queryTotal(Map<String, Object> map);

    @RequestMapping(value="/mute/save",method = RequestMethod.POST)
    void save(MuteEntity mute);

    @RequestMapping(value="/mute/saveBatch",method = RequestMethod.POST)
    void saveBatch(@RequestBody MuteCharMembers mute);

    @RequestMapping(value="/mute/update",method = RequestMethod.POST)
    void update(MuteEntity mute);

    @RequestMapping(value="/mute/delete",method = RequestMethod.POST)
    void delete(@RequestBody Map<String, Object> map);

    @RequestMapping(value="/mute/deleteBatch",method = RequestMethod.POST)
    void deleteBatch(Long[] ids);
}
