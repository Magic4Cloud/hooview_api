package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月24日 18时29分
 * @discription
 */

public class MsgDTO {

    private Long msgId;  //消息id
    private String msgContent;  //消息内容
    private Long sourceId;  //浏览源数据id
    private String sourceType;  //浏览类型（0-直播，1-资讯）
    private String title;  //标题
    private String vid;  //直播vid（浏览类型为资讯时此字段为空）
    private String liveTypeName;  //直播类型（浏览类型为资讯时此字段为空）
    private String logoUrl;  //封面图地址
    private String nickName;  //发送人昵称
    private String roomId;  //环信roomId
    private String headUrl;  //发送人头像地址
    private Integer liveStatus;  //直播状态（0-未直播，1-正在直播）（浏览类型为资讯时此字段为0）
    private String createTime;  //发送时间
    private Integer watchingCount;  //观看人数

    public Integer getWatchingCount() {
        return watchingCount;
    }

    public void setWatchingCount(Integer watchingCount) {
        this.watchingCount = watchingCount;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getLiveTypeName() {
        return liveTypeName;
    }

    public void setLiveTypeName(String liveTypeName) {
        this.liveTypeName = liveTypeName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
