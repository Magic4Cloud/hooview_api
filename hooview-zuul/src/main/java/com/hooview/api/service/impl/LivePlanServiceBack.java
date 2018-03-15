package com.hooview.api.service.impl;

import com.hooview.api.dto.AnchorNameDTO;
import com.hooview.api.dto.CourseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import com.hooview.api.entity.LivePlanEntity;
import com.hooview.api.service.LivePlanService;
import org.springframework.web.bind.annotation.RequestBody;


@Component
public class LivePlanServiceBack implements LivePlanService {

    @Override
    public LivePlanEntity queryObject(Long id){
        return null;
    }

    @Override
    public List<AnchorNameDTO> queryAnchor(Long typeId) {
        return null;
    }

    @Override
    public List<LivePlanEntity> queryObjects(Long id) {
        return null;
    }

    @Override
    public List<LivePlanEntity> queryList(Map<String, Object> map){
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return 0;
    }

    @Override
    public void save(LivePlanEntity livePlan){

    }

    @Override
    public void update(LivePlanEntity livePlan){

    }

    @Override
    public void delete(LivePlanEntity livePlan){

    }

    @Override
    public void deleteBatch(Long[] ids){

    }

    @Override
    public List<CourseDTO> queryCourse(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<CourseDTO> queryCourseTime(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer checkCourse(@RequestBody Map<String, Object> map) {
        return null;
    }
}
