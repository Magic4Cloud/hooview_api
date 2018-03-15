package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 消息表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class MsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//消息id
	private Long msgId;
	//发送者id
	private Long fromUserId;
	//接收者id
	private Long toUserId;
	//来源id
	private Long sourceId;
	//来源类型（0-直播，1-资讯）
	private Integer sourceType;
	//消息内容
	private String msgContent;
	//创建时间
	private Date createTime;
	//是否已读（0-否，1-是）
	private Integer read;

	/**
	 * 设置：消息id
	 */
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：消息id
	 */
	public Long getMsgId() {
		return msgId;
	}
	/**
	 * 设置：发送者id
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	/**
	 * 获取：发送者id
	 */
	public Long getFromUserId() {
		return fromUserId;
	}
	/**
	 * 设置：接收者id
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}
	/**
	 * 获取：接收者id
	 */
	public Long getToUserId() {
		return toUserId;
	}
	/**
	 * 设置：来源id
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * 获取：来源id
	 */
	public Long getSourceId() {
		return sourceId;
	}
	/**
	 * 设置：来源类型（0-直播，1-资讯）
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：来源类型（0-直播，1-资讯）
	 */
	public Integer getSourceType() {
		return sourceType;
	}
	/**
	 * 设置：消息内容
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * 获取：消息内容
	 */
	public String getMsgContent() {
		return msgContent;
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
	 * 设置：是否已读（0-否，1-是）
	 */
	public void setRead(Integer read) {
		this.read = read;
	}
	/**
	 * 获取：是否已读（0-否，1-是）
	 */
	public Integer getRead() {
		return read;
	}
}
