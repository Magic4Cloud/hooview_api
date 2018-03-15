package com.hooview.api.dao;

import com.hooview.api.dto.AnchorNameDTO;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.entity.LivePlanEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 主播课程安排表
 *
 * @author lee
 * @email
 * @date 2018-02-07 11:45:17
 */
@Mapper
public interface LivePlanDao extends BaseDao<LivePlanEntity> {

    List<CourseDTO> queryCourse(Map<String, Object> map);

    List<LivePlanEntity> queryObjects(Long id);

    void deleteCourse(LivePlanEntity livePlanEntity);

    List<AnchorNameDTO> queryAnchor(Long typeId);

    List<CourseDTO> queryCourseTime(Map<String, Object> map);

    Integer checkCourse(Map<String, Object> map);

}
