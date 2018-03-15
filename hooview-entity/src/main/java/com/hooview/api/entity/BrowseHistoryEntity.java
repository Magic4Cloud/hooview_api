package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户浏览历史表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class BrowseHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//浏览历史id
	private Long browseHistoryId;
	//用户id
	private Long userId;
	//浏览来源id
	private Long sourceId;
	//浏览类型（0-直播，1-资讯）
	private Integer sourceType;
	//创建时间
	private Date createTime;

	/**
	 * 设置：浏览历史id
	 */
	public void setBrowseHistoryId(Long browseHistoryId) {
		this.browseHistoryId = browseHistoryId;
	}
	/**
	 * 获取：浏览历史id
	 */
	public Long getBrowseHistoryId() {
		return browseHistoryId;
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
	 * 设置：浏览来源id
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * 获取：浏览来源id
	 */
	public Long getSourceId() {
		return sourceId;
	}
	/**
	 * 设置：浏览类型（0-直播，1-资讯）
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：浏览类型（0-直播，1-资讯）
	 */
	public Integer getSourceType() {
		return sourceType;
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
