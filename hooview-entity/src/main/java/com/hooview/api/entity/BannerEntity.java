package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 轮播图表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class BannerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long bannerId;
	private String  bannerUrl;
	private String bannerTitle;
	private String picUrl;
	private Date createTime;

	public Long getBannerId() {
		return bannerId;
	}

	public void setBannerId(Long bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getBannerTitle() {
		return bannerTitle;
	}

	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
