package com.hooview.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public class LiveDTO {

    //直播id
    private Long liveId;
    //直播标题
    private String liveTitle;
    //直播分类名称
    private String liveTypeName;
    //是否vip直播间（0-否，1-是）
    private Integer liveVip;
    //购买价格
    private BigDecimal livePrice;
    //主播昵称
    private String  nickname;
    //直播状态（0-未直播，1-正在直播，2-回放）对应living
    private Integer liveStatus;
    //是否推荐（0-否，1-是）
    private Integer recommend;
    //结束时间
    private Date liveStopTime;
    //直播地区
    private String location;
    //封面图
    private String logourl;
    //排序字段
    private Integer sortOrder = 0;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getLiveId() {
        return liveId;
    }

    public void setLiveId(Long liveId) {
        this.liveId = liveId;
    }

    public String getLiveTitle() {
        return liveTitle;
    }

    public void setLiveTitle(String liveTitle) {
        this.liveTitle = liveTitle;
    }

    public String getLiveTypeName() {
        return liveTypeName;
    }

    public void setLiveTypeName(String liveTypeName) {
        this.liveTypeName = liveTypeName;
    }

    public Integer getLiveVip() {
        return liveVip;
    }

    public void setLiveVip(Integer liveVip) {
        this.liveVip = liveVip;
    }

    public BigDecimal getLivePrice() {
        return livePrice;
    }

    public void setLivePrice(BigDecimal livePrice) {
        this.livePrice = livePrice;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Date getLiveStopTime() {
        return liveStopTime;
    }

    public void setLiveStopTime(Date liveStopTime) {
        this.liveStopTime = liveStopTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }
}
