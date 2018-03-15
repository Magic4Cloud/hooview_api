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

import com.hooview.api.entity.LiveTypeEntity;
import com.hooview.api.service.LiveTypeService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 直播类型表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class LiveTypeController {
	@Autowired
	private LiveTypeService liveTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/liveType/list")
	//@RequiresPermissions("api:livetype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据

		List<LiveTypeEntity> liveTypeList = liveTypeService.queryList(params);
		
		return R.ok().put("liveTypeList", liveTypeList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/api/liveType/info/{liveTypeId}")
	@RequiresPermissions("api:livetype:info")
	public R info(@PathVariable("liveTypeId") Integer liveTypeId){
		LiveTypeEntity liveType = liveTypeService.queryObject(liveTypeId);
		
		return R.ok().put("liveType", liveType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/liveType/save")
	@RequiresPermissions("api:livetype:save")
	public R save(@RequestBody LiveTypeEntity liveType){
		liveTypeService.save(liveType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/liveType/update")
	@RequiresPermissions("api:livetype:update")
	public R update(@RequestBody LiveTypeEntity liveType){
		liveTypeService.update(liveType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/liveType/delete")
	@RequiresPermissions("api:livetype:delete")
	public R delete(@RequestBody Integer[] liveTypeIds){
		liveTypeService.deleteBatch(liveTypeIds);
		
		return R.ok();
	}
	
}
