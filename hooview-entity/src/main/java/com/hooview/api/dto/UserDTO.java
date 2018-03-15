package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月23日 16时33分
 * @discription
 */
@SuppressWarnings({"unchecked", "unused"})
public class UserDTO {


    //用户id
    private Long userId;
    //昵称
    private String nickname;
    //头像地址
    private String headUrl;
    //手机号
    private String mobile;
    //性别（0-女，1-男，2-未知）
    private Integer sex;
    //地区
    private String region;
    //介绍
    private String introduce;
    //是否主播（0-否，1-是）
    private Integer anchor;
    //主播申请状态(0-未申请，1-待审核，2-审核通过，3-审核不通过)
    private Integer anchorAudit;
    //关注数
    private Integer follow;
    //粉丝数
    private Integer fans;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getAnchor() {
        return anchor;
    }

    public void setAnchor(Integer anchor) {
        this.anchor = anchor;
    }

    public Integer getAnchorAudit() {
        return anchorAudit;
    }

    public void setAnchorAudit(Integer anchorAudit) {
        this.anchorAudit = anchorAudit;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }
}
