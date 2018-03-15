package com.hooview.easemob.service.impl;

import com.hooview.common.easemob.TokenUtil;
import com.hooview.easemob.service.AuthTokenAPI;
import org.springframework.beans.factory.annotation.Autowired;

public class EasemobAuthToken implements AuthTokenAPI{

	@Autowired
	TokenUtil tokenUtil;
	@Override
	public Object getAuthToken(){
		return tokenUtil.getAccessToken();
	}
}
