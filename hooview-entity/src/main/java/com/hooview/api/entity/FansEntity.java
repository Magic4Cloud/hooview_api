package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户粉丝表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class FansEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//被关注用户id
	private Long userId;
	//关注用户id
	private Long fansUserId;
	//是否互相关注（0-否，1-是）
	private Integer mutual;

	/**
	 * 设置：被关注用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：被关注用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：关注用户id
	 */
	public void setFansUserId(Long fansUserId) {
		this.fansUserId = fansUserId;
	}
	/**
	 * 获取：关注用户id
	 */
	public Long getFansUserId() {
		return fansUserId;
	}
	/**
	 * 设置：是否互相关注（0-否，1-是）
	 */
	public void setMutual(Integer mutual) {
		this.mutual = mutual;
	}
	/**
	 * 获取：是否互相关注（0-否，1-是）
	 */
	public Integer getMutual() {
		return mutual;
	}
}
