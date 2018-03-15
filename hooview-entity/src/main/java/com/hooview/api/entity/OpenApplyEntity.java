package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 开户申请表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class OpenApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//开户申请id
	private Long openApplyId;
	//真实姓名
	private String userName;
	//手机号
	private String mobile;
	//审核意见
	private String auditOpinion;
	//申请状态（1-已提交，2-审核通过，3-审核不通过）
	private Integer status;
	//创建时间
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置：开户申请id
	 */
	public void setOpenApplyId(Long openApplyId) {
		this.openApplyId = openApplyId;
	}
	/**
	 * 获取：开户申请id
	 */
	public Long getOpenApplyId() {
		return openApplyId;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getUserName() {
		return userName;
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
	 * 设置：申请状态（1-已提交，2-审核通过，3-审核不通过）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：申请状态（1-已提交，2-审核通过，3-审核不通过）
	 */
	public Integer getStatus() {
		return status;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
}
