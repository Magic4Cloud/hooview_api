package com.hooview.api.service.impl;

import com.hooview.api.dao.LivePlanDao;
import com.hooview.api.dto.AnchorNameDTO;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.entity.LivePlanEntity;
import com.hooview.api.service.LivePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LivePlanServiceImpl")
public class LivePlanServiceImpl implements LivePlanService {

    @Autowired
    LivePlanDao livePlanDao;
    @Override
    public LivePlanEntity queryObject(Long id) {
        return livePlanDao.queryObject(id);
    }

    @Override
    public List<AnchorNameDTO> queryAnchor(@RequestParam("typeId") Long typeId) {
        return livePlanDao.queryAnchor(typeId);
    }

    @Override
    public List<LivePlanEntity> queryObjects(@RequestParam("userId") Long userId) {
        return livePlanDao.queryObjects(userId);
    }

    @Override
    public List<LivePlanEntity> queryList(Map<String, Object> map) {
        return livePlanDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return livePlanDao.queryTotal(map);
    }

    @Override
    public void save(@RequestBody LivePlanEntity livePlan) {
        livePlanDao.save(livePlan);
    }

    @Override
    public void update(@RequestBody LivePlanEntity livePlan) {
        livePlanDao.update(livePlan);
    }

    @Override
    public void delete(@RequestBody LivePlanEntity livePlan) {
        livePlanDao.deleteCourse(livePlan);
    }

    @Override
    public void deleteBatch(Long[] ids) {

    }

    @Override
    public List<CourseDTO> queryCourse(@RequestParam Map<String, Object> map) {
        return livePlanDao.queryCourse(map);
    }

    @Override
    public List<CourseDTO> queryCourseTime(@RequestParam Map<String, Object> map) {
        return livePlanDao.queryCourseTime(map);
    }

    @Override
    public Integer checkCourse(@RequestBody Map<String, Object> map) {
        return livePlanDao.checkCourse(map);
    }
}
