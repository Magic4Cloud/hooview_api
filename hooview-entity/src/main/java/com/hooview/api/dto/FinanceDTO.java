package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月25日 17时39分
 * @discription
 */
@SuppressWarnings({"unchecked", "unused"})
public class FinanceDTO {

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
    //用户昵称
    private String nickname;
    //头像地址
    private String headUrl;
    //介绍
    private String introduce;
    //创建时间
    private String createTime;
    //机构名称
    private String agencyName;

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
