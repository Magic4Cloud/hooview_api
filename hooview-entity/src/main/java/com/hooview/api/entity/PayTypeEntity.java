package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 支付方式表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class PayTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//支付方式id
	private Integer payTypeId;
	//支付方式名称
	private String payTypeName;
	//appid
	private String appid;
	//商户id
	private String mchId;
	//是否启用（0-不启用，1-启用）
	private Integer status;

	/**
	 * 设置：支付方式id
	 */
	public void setPayTypeId(Integer payTypeId) {
		this.payTypeId = payTypeId;
	}
	/**
	 * 获取：支付方式id
	 */
	public Integer getPayTypeId() {
		return payTypeId;
	}
	/**
	 * 设置：支付方式名称
	 */
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	/**
	 * 获取：支付方式名称
	 */
	public String getPayTypeName() {
		return payTypeName;
	}
	/**
	 * 设置：appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 获取：appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * 设置：商户id
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 获取：商户id
	 */
	public String getMchId() {
		return mchId;
	}
	/**
	 * 设置：是否启用（0-不启用，1-启用）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否启用（0-不启用，1-启用）
	 */
	public Integer getStatus() {
		return status;
	}
}
