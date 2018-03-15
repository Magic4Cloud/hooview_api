package com.hooview.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hooview.api.dto.AnchorNameDTO;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.dto.LivePlanDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.LivePlanEntity;
import com.hooview.api.service.LivePlanService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 主播课程安排表
 *
 * @author lee
 * @email
 * @date 2018-02-07 11:45:17
 */
@RestController
public class LivePlanController {
    @Autowired
    private LivePlanService livePlanService;

    /**
     * 列表
     */
    @RequestMapping("/livePlan/list")
    @RequiresPermissions("api:liveplan:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<LivePlanEntity> livePlanList = livePlanService.queryList(query);
        int total = livePlanService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(livePlanList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/livePlan/info/{id}")
    @RequiresPermissions("api:liveplan:info")
    public R info(@PathVariable("id") Long id){
        LivePlanEntity livePlan = livePlanService.queryObject(id);
        return R.ok().put("livePlan", livePlan);
    }

    /**
     * 信息
     */
    @RequestMapping(value = "/api/livePlan/course",method = RequestMethod.GET)
    public R course(@RequestParam("userId") Long userId){
        List<LivePlanDTO> livePlans = infoCourse(userId);
        return R.ok().put("livePlan",livePlans);
    }

    @RequestMapping(value = "/admin/livePlan/course",method = RequestMethod.GET)
    public R adminCourse(@RequestParam("userId") Long userId){
        List<LivePlanDTO> livePlans = infoCourse(userId);
        return R.ok().put("livePlan",livePlans);
    }

    private List<LivePlanDTO> infoCourse(@RequestParam("userId") Long userId) {
        List<LivePlanDTO> livePlans = new ArrayList<>();
        List<LivePlanEntity> livePlan = livePlanService.queryObjects(userId);
        for(int i = 1;i<8;i++){
            LivePlanDTO livePlanDTO = new LivePlanDTO();
            List<CourseDTO> courses = new ArrayList<>();
            livePlanDTO.setDayOfWeek(i);
            for(LivePlanEntity planEntity : livePlan){
                if(planEntity.getDayOfWeek().equals(i)){
                    CourseDTO courseDTO = new CourseDTO();
                    courseDTO.setStartTime(planEntity.getStartTime());
                    courseDTO.setEndTime(planEntity.getEndTime());
                    courseDTO.setCourse(planEntity.getCourse());
                    courseDTO.setId(planEntity.getId());
                    courses.add(courseDTO);
                }
        }
            livePlanDTO.setCourses(courses);
            livePlans.add(livePlanDTO);
        }
        return livePlans;
    }


    /**
     * 选老师（主播）
     */
    @RequestMapping(value = "/api/livePlan/anchor",method = RequestMethod.GET)
    public R queryAnchor(@RequestParam("typeId") Long typeId){
        List<AnchorNameDTO>  anchor = livePlanService.queryAnchor(typeId);
        return R.ok().put("anchor",anchor);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "admin/livePlan/save",method = RequestMethod.POST)
    @RequiresPermissions("api:liveplan:save")
    public R save(@RequestBody LivePlanEntity livePlan){
        Map<String ,Object> map = new HashMap<>();
        Long userId = livePlan.getUserId();
        String sTime = livePlan.getStartTime();
        String eTime = livePlan.getEndTime();
        Integer dayOfWeek = livePlan.getDayOfWeek();
        map.put("userId",userId);
        map.put("dayOfWeek",dayOfWeek);
        List<CourseDTO> list = livePlanService.queryCourseTime(map);
        for(CourseDTO course : list){
            Map<String ,Object> map1 = new HashMap<>();
            map1.put("userId",userId);
            map1.put("dayOfWeek",dayOfWeek);
            map1.put("sTime",sTime);
            map1.put("eTime",eTime);
            map1.put("startTime",course.getStartTime());
            map1.put("endTime",course.getEndTime());
            Integer count = livePlanService.checkCourse(map1);
            if(count != null && count > 0){
                return R.error("时间冲突");
            }
        }
        livePlanService.save(livePlan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "admin/livePlan/update",method = RequestMethod.POST)
    @RequiresPermissions("api:liveplan:update")
    public R update(@RequestBody LivePlanEntity livePlan){
        livePlanService.update(livePlan);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "admin/livePlan/delete",method = RequestMethod.POST)
    @RequiresPermissions("api:liveplan:delete")
    public R delete(@RequestBody LivePlanEntity livePlan){
        livePlanService.delete(livePlan);

        return R.ok();
    }

}
