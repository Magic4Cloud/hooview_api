package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 直播提醒表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class RemindEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//直播id
	private Long liveId;
	//用户id
	private Long userId;

	/**
	 * 设置：直播id
	 */
	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}
	/**
	 * 获取：直播id
	 */
	public Long getLiveId() {
		return liveId;
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
}
