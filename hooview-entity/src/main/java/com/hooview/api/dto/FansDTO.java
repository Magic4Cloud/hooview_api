package com.hooview.api.dto;

public class FansDTO {

    //用户id
    private Long userId;
    //昵称
    private String nickname;
    //头像地址
    private String headUrl;
    //介绍
    private String introduce;
    //是否互相关注
    private Integer mutual;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getMutual() {
        return mutual;
    }

    public void setMutual(Integer mutual) {
        this.mutual = mutual;
    }
}
