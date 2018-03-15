package com.hooview.api.dto;

public class ApplyAnchorDTO {

    private Long userId;

    private String username;

    private String phone;

    private String anchorAudit;

    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAnchorAudit() {
        return anchorAudit;
    }

    public void setAnchorAudit(String anchorAudit) {
        this.anchorAudit = anchorAudit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
