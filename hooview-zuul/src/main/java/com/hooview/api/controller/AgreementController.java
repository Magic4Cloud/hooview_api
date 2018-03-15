package com.hooview.api.controller;

import com.hooview.api.entity.AgreementEntity;
import com.hooview.api.service.AgreementService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




/**
 * 协议表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class AgreementController {
	@Autowired
	private AgreementService agreementService;

	/**
	 * 注册协议信息
	 */
	@RequestMapping("/api/user/agreement")
	public R queryUserAgreement(){
		AgreementEntity agreement = agreementService.queryUserAgreement();
		return R.ok().put("userAgreement", agreement.getUserAgreement());
	}

	/**
	 * 主播协议信息
	 */
	@RequestMapping("/api/user/anchorAgreement")
	public R queryAnchorAgreement(){
		AgreementEntity agreement = agreementService.queryUserAgreement();
		return R.ok().put("anchorAgreement", agreement.getAnchorAgreement());
	}

	
	/**
	 * 修改
	 */
	@RequestMapping("/admin/user/updateAgreement")
	@RequiresPermissions("admin:agreement:update")
	public R update(@RequestBody AgreementEntity agreement){
		agreementService.update(agreement);
		
		return R.ok();
	}
	

	
}
