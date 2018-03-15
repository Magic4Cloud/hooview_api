package com.hooview.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 用户表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户id
	private Long userId;
	//昵称
	private String nickname;
	//姓名
	private String username;
	//密码
	private String password;
	//盐
	private String salt;
	//头像地址
	private String headUrl;
	//邮箱
	private String email;
	//手机号
	private String mobile;
	//性别（0-女，1-男，2-未知）
	private Integer sex;
	//地区
	private String region;
	//介绍
	private String introduce;
	//是否主播（0-否，1-是）
	private Integer anchor;
	//状态  0：禁用   1：正常
	private Integer status;
	//主播申请状态(0-未申请，1-待审核，2-审核通过，3-审核不通过)
	private Integer anchorAudit;
	//关注数
	private Integer follow;
	//粉丝数
	private Integer fans;
	//创建时间
	private Date createTime;
	//申请主播时间
	private Date anchorTime;
	//易直播id
	private String yiId;
	//机构id
	private Long agencyId;
	//直播类型id
	private Integer liveTypeId;

	public Integer getLiveTypeId() {
		return liveTypeId;
	}

	public void setLiveTypeId(Integer liveTypeId) {
		this.liveTypeId = liveTypeId;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Date getAnchorTime() {
		return anchorTime;
	}

	public void setAnchorTime(Date anchorTime) {
		this.anchorTime = anchorTime;
	}

	public String getYiId() {
		return yiId;
	}

	public void setYiId(String yiId) {
		this.yiId = yiId;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList;

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
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：头像地址
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	/**
	 * 获取：头像地址
	 */
	public String getHeadUrl() {
		return headUrl;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：性别（0-女，1-男，2-未知）
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别（0-女，1-男，2-未知）
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：地区
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 获取：地区
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：是否主播（0-否，1-是）
	 */
	public void setAnchor(Integer anchor) {
		this.anchor = anchor;
	}
	/**
	 * 获取：是否主播（0-否，1-是）
	 */
	public Integer getAnchor() {
		return anchor;
	}
	/**
	 * 设置：状态  0：禁用   1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态  0：禁用   1：正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：主播申请状态(0-未申请，1-待审核，2-审核通过，3-审核不通过)
	 */
	public void setAnchorAudit(Integer anchorAudit) {
		this.anchorAudit = anchorAudit;
	}
	/**
	 * 获取：主播申请状态(0-未申请，1-待审核，2-审核通过，3-审核不通过)
	 */
	public Integer getAnchorAudit() {
		return anchorAudit;
	}
	/**
	 * 设置：关注数
	 */
	public void setFollow(Integer follow) {
		this.follow = follow;
	}
	/**
	 * 获取：关注数
	 */
	public Integer getFollow() {
		return follow;
	}
	/**
	 * 设置：粉丝数
	 */
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	/**
	 * 获取：粉丝数
	 */
	public Integer getFans() {
		return fans;
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
