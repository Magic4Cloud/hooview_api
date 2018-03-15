package com.hooview.api.service;

import com.hooview.api.dto.AnchorNameDTO;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.entity.LivePlanEntity;
import com.hooview.api.service.impl.LivePlanServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 主播课程安排表
 *
 * @author lee
 * @email
 * @date 2018-02-07 11:45:17
 */
@FeignClient(value = "hooview-service",fallback = LivePlanServiceBack.class)
public interface LivePlanService {

    @RequestMapping(value="/livePlan/queryObject",method = RequestMethod.GET)
    LivePlanEntity queryObject(Long id);

    @RequestMapping(value="/livePlan/queryAnchor",method = RequestMethod.GET)
    List<AnchorNameDTO> queryAnchor(@RequestParam("typeId") Long typeId);

    @RequestMapping(value="/livePlan/queryObjects",method = RequestMethod.GET)
    List<LivePlanEntity> queryObjects(@RequestParam("userId") Long userId);

    @RequestMapping(value="/livePlan/queryList",method = RequestMethod.GET)
    List<LivePlanEntity> queryList(Map<String, Object> map);

    @RequestMapping(value="/livePlan/queryTotal",method = RequestMethod.GET)
    int queryTotal(Map<String, Object> map);

    @RequestMapping(value="/livePlan/save",method = RequestMethod.POST)
    void save(@RequestBody LivePlanEntity livePlan);

    @RequestMapping(value="/livePlan/update",method = RequestMethod.POST)
    void update(@RequestBody LivePlanEntity livePlan);

    @RequestMapping(value="/livePlan/delete",method = RequestMethod.POST)
    void delete(@RequestBody LivePlanEntity livePlan);

    @RequestMapping(value="/livePlan/deleteBatch",method = RequestMethod.POST)
    void deleteBatch(Long[] ids);

    @RequestMapping(value="/livePlan/queryCourse",method = RequestMethod.GET)
    List<CourseDTO> queryCourse(@RequestParam Map<String, Object> map);

    @RequestMapping(value="/livePlan/queryCourseTime",method = RequestMethod.GET)
    List<CourseDTO> queryCourseTime(@RequestParam Map<String, Object> map);

    @RequestMapping(value="/livePlan/checkCourse",method = RequestMethod.POST)
    Integer checkCourse(@RequestBody Map<String, Object> map);
}
