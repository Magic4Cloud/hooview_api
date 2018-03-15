package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class FinanceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//财经资讯id
	private Long financeInfoId;
	//标题
	private String title;
	//内容
	private String content;
	//摘要
	private String summary;
	//封面图
	private String coverPic;
	//关键字（逗号分隔）
	private String keyword;
	//状态（0-隐藏，1-显示）
	private Integer status;
	//类型（1-发布的，2-爬取的）
	private Integer type;
	//来源地址（爬虫有）
	private String sourceUrl;
	//是否为banner(0-否，1-是)
	private Integer banner;
	//点赞数
	private Integer praiseNum;
	//创建人id
	private Long createUserId;
	//创建时间
	private Date createTime;
	//头像地址
	private String headUrl;
	//机构名称
	private int agencyId;

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 设置：财经资讯id
	 */
	public void setFinanceInfoId(Long financeInfoId) {
		this.financeInfoId = financeInfoId;
	}
	/**
	 * 获取：财经资讯id
	 */
	public Long getFinanceInfoId() {
		return financeInfoId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：封面图
	 */
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	/**
	 * 获取：封面图
	 */
	public String getCoverPic() {
		return coverPic;
	}
	/**
	 * 设置：关键字（逗号分隔）
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 获取：关键字（逗号分隔）
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * 设置：状态（0-隐藏，1-显示）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0-隐藏，1-显示）
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：类型（1-发布的，2-爬取的）
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型（1-发布的，2-爬取的）
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：来源地址（爬虫有）
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	/**
	 * 获取：来源地址（爬虫有）
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}
	/**
	 * 设置：是否为banner(0-否，1-是)
	 */
	public void setBanner(Integer banner) {
		this.banner = banner;
	}
	/**
	 * 获取：是否为banner(0-否，1-是)
	 */
	public Integer getBanner() {
		return banner;
	}
	/**
	 * 设置：点赞数
	 */
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getPraiseNum() {
		return praiseNum;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getCreateUserId() {
		return createUserId;
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
