package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 直播表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class LiveEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//直播id
	private Long liveId;
	//直播标题
	private String liveTitle;
	//直播描述
	private String liveInfo;
	//直播地址
	private String liveUrl;
	//直播分类id
	private Long liveTypeId;
	//是否vip直播间（0-否，1-是）
	private Integer liveVip;
	//购买价格
	private BigDecimal livePrice;
	//主播id
	private Long userId;
	//直播状态（0-未直播，1-正在直播，2-回放）对应living
	private Integer liveStatus;
	//是否推荐（0-否，1-是）
	private Integer recommend;
	//创建时间
	private Date createTime;
	//易直播唯一id
	private String vid;
	//观看统计
	private Integer watchCount;
	//点赞统计
	private Integer likeCount;
	//正在观看人数
	private Integer watchingCount;
	//回看视频时长
	private Integer duration;
	//结束时间
	private Date liveStopTime;
	//直播地址
	private String location;
	//封面图
	private String logourl;
	//聊天室id
	private String roomId;
	//排序字段
	private Integer sortOrder;
	//分类名称
	private String liveTypeName;

	public String getLiveTypeName() {
		return liveTypeName;
	}

	public void setLiveTypeName(String liveTypeName) {
		this.liveTypeName = liveTypeName;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * 设置：直播id
	 */
	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}
	/**
	 * 获取：直播id
	 */
	public Long getLiveId() {
		return liveId;
	}
	/**
	 * 设置：直播标题
	 */
	public void setLiveTitle(String liveTitle) {
		this.liveTitle = liveTitle;
	}
	/**
	 * 获取：直播标题
	 */
	public String getLiveTitle() {
		return liveTitle;
	}
	/**
	 * 设置：直播描述
	 */
	public void setLiveInfo(String liveInfo) {
		this.liveInfo = liveInfo;
	}
	/**
	 * 获取：直播描述
	 */
	public String getLiveInfo() {
		return liveInfo;
	}
	/**
	 * 设置：直播地址
	 */
	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}
	/**
	 * 获取：直播地址
	 */
	public String getLiveUrl() {
		return liveUrl;
	}
	/**
	 * 设置：直播分类id
	 */
	public void setLiveTypeId(Long liveTypeId) {
		this.liveTypeId = liveTypeId;
	}
	/**
	 * 获取：直播分类id
	 */
	public Long getLiveTypeId() {
		return liveTypeId;
	}
	/**
	 * 设置：是否vip直播间（0-否，1-是）
	 */
	public void setLiveVip(Integer liveVip) {
		this.liveVip = liveVip;
	}
	/**
	 * 获取：是否vip直播间（0-否，1-是）
	 */
	public Integer getLiveVip() {
		return liveVip;
	}
	/**
	 * 设置：购买价格
	 */
	public void setLivePrice(BigDecimal livePrice) {
		this.livePrice = livePrice;
	}
	/**
	 * 获取：购买价格
	 */
	public BigDecimal getLivePrice() {
		return livePrice;
	}
	/**
	 * 设置：主播id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：主播id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：直播状态（0-未直播，1-正在直播，2-回放）对应living
	 */
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	/**
	 * 获取：直播状态（0-未直播，1-正在直播，2-回放）对应living
	 */
	public Integer getLiveStatus() {
		return liveStatus;
	}
	/**
	 * 设置：是否推荐（0-否，1-是）
	 */
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	/**
	 * 获取：是否推荐（0-否，1-是）
	 */
	public Integer getRecommend() {
		return recommend;
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
	/**
	 * 设置：易直播唯一id
	 */
	public void setVid(String vid) {
		this.vid = vid;
	}
	/**
	 * 获取：易直播唯一id
	 */
	public String getVid() {
		return vid;
	}
	/**
	 * 设置：观看统计
	 */
	public void setWatchCount(Integer watchCount) {
		this.watchCount = watchCount;
	}
	/**
	 * 获取：观看统计
	 */
	public Integer getWatchCount() {
		return watchCount;
	}
	/**
	 * 设置：点赞统计
	 */
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	/**
	 * 获取：点赞统计
	 */
	public Integer getLikeCount() {
		return likeCount;
	}
	/**
	 * 设置：正在观看人数
	 */
	public void setWatchingCount(Integer watchingCount) {
		this.watchingCount = watchingCount;
	}
	/**
	 * 获取：正在观看人数
	 */
	public Integer getWatchingCount() {
		return watchingCount;
	}
	/**
	 * 设置：回看视频时长
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * 获取：回看视频时长
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * 设置：结束时间
	 */
	public void setLiveStopTime(Date liveStopTime) {
		this.liveStopTime = liveStopTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getLiveStopTime() {
		return liveStopTime;
	}
	/**
	 * 设置：直播地址
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：直播地址
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：封面图
	 */
	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}
	/**
	 * 获取：封面图
	 */
	public String getLogourl() {
		return logourl;
	}
}
