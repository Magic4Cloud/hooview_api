package com.hooview.api.entity;

import java.io.Serializable;


/**
 * 财经资讯点赞表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:25:33
 */
public class FinancePraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//财经资讯id
	private Long financeInfoId;
	//用户id
	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
