package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资讯评论表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class InfoCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资讯评论id
	private Long infoCommentId;
	//财经资讯id
	private Long financeInfoId;
	//评论
	private String comment;
	//用户id
	private Long userId;
	//创建时间
	private Date createTime;
	//点赞数
	private Integer praiseNum;

	/**
	 * 设置：资讯评论id
	 */
	public void setInfoCommentId(Long infoCommentId) {
		this.infoCommentId = infoCommentId;
	}
	/**
	 * 获取：资讯评论id
	 */
	public Long getInfoCommentId() {
		return infoCommentId;
	}
	/**
	 * 设置：财经资讯id
	 */
	public void setFinanceInfoId(Long financeInfoId) {
		this.financeInfoId = financeInfoId;
	}
	/**
	 * 获取：财经资讯id
	 */
	public Long getFinanceInfoId() {
		return financeInfoId;
	}
	/**
	 * 设置：评论
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评论
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：点赞数
	 */
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getPraiseNum() {
		return praiseNum;
	}
}
