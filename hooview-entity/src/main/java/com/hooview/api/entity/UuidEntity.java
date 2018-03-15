package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * uuid表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class UuidEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//uuid
	private String uuid;
	//过期时间
	private Date expiretime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 设置：过期时间
	 */
	public void setExpiretime(Date expiretime) {
		this.expiretime = expiretime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpiretime() {
		return expiretime;
	}
}
