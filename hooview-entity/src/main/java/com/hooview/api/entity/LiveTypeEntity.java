package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 直播类型表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class LiveTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//直播类型表
	private Integer liveTypeId;
	//直播类型名称
	private String typeName;
	//是否启用（0-禁用，1-启用）
	private Integer status;

	/**
	 * 设置：直播类型表
	 */
	public void setLiveTypeId(Integer liveTypeId) {
		this.liveTypeId = liveTypeId;
	}
	/**
	 * 获取：直播类型表
	 */
	public Integer getLiveTypeId() {
		return liveTypeId;
	}
	/**
	 * 设置：直播类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：直播类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：是否启用（0-禁用，1-启用）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否启用（0-禁用，1-启用）
	 */
	public Integer getStatus() {
		return status;
	}
}
