package com.hooview.api.entity;

import java.io.Serializable;


/**
 * 财经资讯点赞表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class InfoCommentPraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//财经资讯评论id
	private Long infoCommentId;
	//用户id
	private Long userId;

	public Long getInfoCommentId() {
		return infoCommentId;
	}

	public void setInfoCommentId(Long infoCommentId) {
		this.infoCommentId = infoCommentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
