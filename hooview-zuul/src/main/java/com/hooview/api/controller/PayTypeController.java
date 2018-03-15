package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hooview.api.entity.PayTypeEntity;
import com.hooview.api.service.PayTypeService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 支付方式表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class PayTypeController {
	@Autowired
	private PayTypeService payTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/payType/list")
	@RequiresPermissions("api:paytype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PayTypeEntity> payTypeList = payTypeService.queryList(query);
		int total = payTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(payTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/payType/info/{payTypeId}")
	@RequiresPermissions("api:paytype:info")
	public R info(@PathVariable("payTypeId") Integer payTypeId){
		PayTypeEntity payType = payTypeService.queryObject(payTypeId);
		
		return R.ok().put("payType", payType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/payType/save")
	@RequiresPermissions("api:paytype:save")
	public R save(@RequestBody PayTypeEntity payType){
		payTypeService.save(payType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/payType/update")
	@RequiresPermissions("api:paytype:update")
	public R update(@RequestBody PayTypeEntity payType){
		payTypeService.update(payType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/payType/delete")
	@RequiresPermissions("api:paytype:delete")
	public R delete(@RequestBody Integer[] payTypeIds){
		payTypeService.deleteBatch(payTypeIds);
		
		return R.ok();
	}
	
}
