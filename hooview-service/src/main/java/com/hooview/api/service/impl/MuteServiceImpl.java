package com.hooview.api.service.impl;

import com.hooview.api.dao.MuteDao;
import com.hooview.api.dto.MuteCharMembers;
import com.hooview.api.entity.MuteEntity;
import com.hooview.api.service.MuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
@Service("muteService")
public class MuteServiceImpl implements MuteService {

    @Autowired
    private MuteDao muteDao;
    @Override
    public MuteEntity queryObject(Long id) {
        return null;
    }

    @Override
    public List<MuteEntity> queryMuteList(@RequestParam Map<String, Object> map) {
        return muteDao.queryMuteList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(MuteEntity mute) {
        muteDao.save(mute);
    }

    @Override
    public void saveBatch(@RequestBody MuteCharMembers mute) {
        muteDao.saveBatch(mute);
    }

    @Override
    public void update(MuteEntity mute) {

    }

    @Override
    public void delete(@RequestBody Map<String, Object> map) {
        muteDao.delete(map);
    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
