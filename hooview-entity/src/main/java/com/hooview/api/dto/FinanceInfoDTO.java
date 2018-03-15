package com.hooview.api.dto;

import java.util.List;

/**
 * @auther lee
 * @createTime 2018年01月25日 17时43分
 * @discription
 */

public class FinanceInfoDTO {
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
    //机构名称
    private String agencyName;
    //介绍
    private String introduce;
    //创建时间
    private String createTime;
    //关键字（逗号分隔)
    private String keyword;
    //来源地址
    private String sourceUrl;
    //点赞数
    private Integer praiseNum;
    //是否收藏
    private Integer follow;
    //是否点赞
    private Integer praise;
    //是否收藏
    private Integer collection;
    //作者id
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    private List<RecommendDTO> recommendList;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public List<RecommendDTO> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<RecommendDTO> recommendList) {
        this.recommendList = recommendList;
    }
}
