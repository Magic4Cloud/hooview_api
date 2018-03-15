package com.hooview.api.dto;

public class AdminFinanceInfoDTO {

    //财经资讯id
    private Long financeInfoId;
    //标题
    private String title;
    //摘要
    private String summary;
    //内容
    private String content;
    //封面图
    private String coverPic;
    //来源地址
    private String sourceUrl;
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
    //头像地址
    private String headUrl;
    //机构id
    private int agencyId;

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
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
