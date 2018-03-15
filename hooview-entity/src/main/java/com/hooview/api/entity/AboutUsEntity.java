package com.hooview.api.entity;

import java.io.Serializable;


/**
 * 关于表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class AboutUsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//关于我们
	private String aboutUs;

	/**
	 * 设置：关于我们
	 */
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	/**
	 * 获取：关于我们
	 */
	public String getAboutUs() {
		return aboutUs;
	}
}
