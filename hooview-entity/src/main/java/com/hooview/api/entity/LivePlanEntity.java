package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 主播课程安排表
 *
 * @author lee
 * @email
 * @date 2018-02-07 11:45:17
 */
public class LivePlanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //主播id
    private Long userId;
    //星期几
    private Integer dayOfWeek;
    //开始时间
    private String  startTime;
    //结束时间
    private String endTime;
    //课程名
    private String course;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 设置：星期几
     */
    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    /**
     * 获取：星期几
     */
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }
    /**
     * 设置：开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 设置：课程名
     */
    public void setCourse(String course) {
        this.course = course;
    }
    /**
     * 获取：课程名
     */
    public String getCourse() {
        return course;
    }
}
