package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 协议表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class AgreementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户协议
	private String userAgreement;
	//主播协议
	private String anchorAgreement;

	/**
	 * 设置：用户协议
	 */
	public void setUserAgreement(String userAgreement) {
		this.userAgreement = userAgreement;
	}
	/**
	 * 获取：用户协议
	 */
	public String getUserAgreement() {
		return userAgreement;
	}
	/**
	 * 设置：主播协议
	 */
	public void setAnchorAgreement(String anchorAgreement) {
		this.anchorAgreement = anchorAgreement;
	}
	/**
	 * 获取：主播协议
	 */
	public String getAnchorAgreement() {
		return anchorAgreement;
	}
}
