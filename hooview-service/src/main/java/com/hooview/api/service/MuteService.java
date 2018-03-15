package com.hooview.api.service;

import com.hooview.api.dto.MuteCharMembers;
import com.hooview.api.entity.MuteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public interface MuteService {

    @RequestMapping(value="/mute/queryObject",method = RequestMethod.GET)
    MuteEntity queryObject(Long id);

    @RequestMapping(value="/mute/queryMuteList",method = RequestMethod.GET)
    List<MuteEntity> queryMuteList(Map<String, Object> map);

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
