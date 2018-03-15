package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class CodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//验证码
	private String code;
	//电话
	private String mobile;
	//过期时间
	private Date expiretime;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：验证码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：验证码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
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
