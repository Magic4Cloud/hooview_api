package com.hooview.api.dto;


public class CommentDTO {
    private Long infoCommentId;
    private String comment;
    private String nickname;
    private String headUrl;
    private String createTime;
    private Integer praiseNum;
    //是否点赞
    private Integer praise;

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Long getInfoCommentId() {
        return infoCommentId;
    }

    public void setInfoCommentId(Long infoCommentId) {
        this.infoCommentId = infoCommentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }
}
