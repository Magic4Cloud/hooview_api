package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 订单表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单id
	private Long orderId;
	//订单编号
	private String orderNo;
	//直播id
	private Long liveId;
	//订单价格
	private BigDecimal orderPrice;
	//订单提交用户id
	private Long userId;
	//创建时间
	private Date createTime;
	//订单状态（1-待支付，2-已支付，3-已取消）
	private Integer status;
	//支付方式id
	private Integer payTypeId;
	//支付时间
	private Date payTime;

	/**
	 * 设置：订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
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
	 * 设置：订单价格
	 */
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	/**
	 * 获取：订单价格
	 */
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	/**
	 * 设置：订单提交用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：订单提交用户id
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：订单状态（1-待支付，2-已支付，3-已取消）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态（1-待支付，2-已支付，3-已取消）
	 */
	public Integer getStatus() {
		return status;
	}
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
	 * 设置：支付时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getPayTime() {
		return payTime;
	}
}
