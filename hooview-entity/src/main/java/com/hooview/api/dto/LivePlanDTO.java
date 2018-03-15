package com.hooview.api.dto;

import java.util.List;

public class LivePlanDTO {
    //星期几
    private Integer dayOfWeek;
    //课程计划
    private List<CourseDTO> courses;

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
