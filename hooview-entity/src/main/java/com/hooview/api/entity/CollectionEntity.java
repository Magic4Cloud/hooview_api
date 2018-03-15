package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户收藏表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class CollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//收藏id
	private Long collectionId;
	//用户id
	private Long userId;
	//收藏来源id
	private Long sourceId;
	//收藏类型（0-直播，1-资讯）
	private Integer sourceType;
	//创建时间
	private Date createTime;

	/**
	 * 设置：收藏id
	 */
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	/**
	 * 获取：收藏id
	 */
	public Long getCollectionId() {
		return collectionId;
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
	 * 设置：收藏来源id
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * 获取：收藏来源id
	 */
	public Long getSourceId() {
		return sourceId;
	}
	/**
	 * 设置：收藏类型（0-直播，1-资讯）
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：收藏类型（0-直播，1-资讯）
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
