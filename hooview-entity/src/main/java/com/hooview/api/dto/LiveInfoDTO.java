package com.hooview.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public class LiveInfoDTO {

    //直播id
    private Long liveId;
    //直播标题
    private String liveTitle;
    //直播描述
    private String liveInfo;
    //头像地址
    private String headUrl;
    //直播分类id
    private Long liveTypeId;
    //直播分类名称
    private String liveTypeName;
    //是否vip直播间（0-否，1-是）
    private Integer liveVip;
    //购买价格
    private BigDecimal livePrice;
    //主播id
    private Long userId;
    //主播昵称
    private String  nickname;
    //直播状态（0-未直播，1-正在直播，2-回放）对应living
    private Integer liveStatus;
    //是否推荐（0-否，1-是）
    private Integer recommend;
    //创建时间
    private Date createTime;
    //易直播唯一id
    private String vid;
    //观看统计
    private Integer watchCount;
    //点赞统计
    private Integer likeCount;
    //正在观看人数
    private Integer watchingCount;
    //回看视频时长
    private Integer duration;
    //结束时间
    private Date liveStopTime;
    //直播地址
    private String location;
    //封面图
    private String logourl;
    //聊天室id
    private String roomId;
    //是否关注
    private int follow;
    //是否收藏
    private Integer collection;

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
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

    public String getLiveInfo() {
        return liveInfo;
    }

    public void setLiveInfo(String liveInfo) {
        this.liveInfo = liveInfo;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Long getLiveTypeId() {
        return liveTypeId;
    }

    public void setLiveTypeId(Long liveTypeId) {
        this.liveTypeId = liveTypeId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getWatchingCount() {
        return watchingCount;
    }

    public void setWatchingCount(Integer watchingCount) {
        this.watchingCount = watchingCount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getLiveTypeName() {
        return liveTypeName;
    }

    public void setLiveTypeName(String liveTypeName) {
        this.liveTypeName = liveTypeName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
