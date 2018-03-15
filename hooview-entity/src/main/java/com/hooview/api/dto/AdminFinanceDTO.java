package com.hooview.api.dto;

public class AdminFinanceDTO {
    //财经资讯id
    private Long financeInfoId;
    //标题
    private String title;
    //键字（逗号分隔）
    private String keyword;
    //状态（0-隐藏，1-显示）
    private Integer status;
    //类型（1-发布的，2-爬取的）
    private Integer type;
    //点赞数
    private Integer praiseNum;
    //创建人姓名
    private String createUserName;
    //创建时间
    private String createTime;

    public Long getFinanceInfoId() {
        return financeInfoId;
    }

    public void setFinanceInfoId(Long financeInfoId) {
        this.financeInfoId = financeInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
