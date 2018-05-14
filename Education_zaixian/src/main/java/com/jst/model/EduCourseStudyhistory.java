package com.jst.model;

import java.util.Date;

public class EduCourseStudyhistory {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer kpointId;

    private Integer playercount;

    private String courseName;

    private String kpointName;

    private Date updateTime;

    private String databack;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getKpointId() {
        return kpointId;
    }

    public void setKpointId(Integer kpointId) {
        this.kpointId = kpointId;
    }

    public Integer getPlayercount() {
        return playercount;
    }

    public void setPlayercount(Integer playercount) {
        this.playercount = playercount;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getKpointName() {
        return kpointName;
    }

    public void setKpointName(String kpointName) {
        this.kpointName = kpointName == null ? null : kpointName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataback() {
        return databack;
    }

    public void setDataback(String databack) {
        this.databack = databack == null ? null : databack.trim();
    }
}