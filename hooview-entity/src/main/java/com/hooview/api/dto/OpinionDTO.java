package com.hooview.api.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * 意见反馈表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class OpinionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//意见id
	private Long opinionId;
	//用户昵称
	private String nickname;
	//意见详情
	private String opinionContent;
	//创建时间
	private Date createTime;
	//状态
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设置：意见id
	 */
	public void setOpinionId(Long opinionId) {
		this.opinionId = opinionId;
	}
	/**
	 * 获取：意见id
	 */
	public Long getOpinionId() {
		return opinionId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 设置：意见详情
	 */
	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}
	/**
	 * 获取：意见详情
	 */
	public String getOpinionContent() {
		return opinionContent;
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
}
