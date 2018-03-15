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

import com.hooview.api.entity.RemindEntity;
import com.hooview.api.service.RemindService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 直播提醒表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class RemindController {
	@Autowired
	private RemindService remindService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/remind/list")
	@RequiresPermissions("api:remind:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RemindEntity> remindList = remindService.queryList(query);
		int total = remindService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(remindList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/remind/info/{liveId}")
	@RequiresPermissions("api:remind:info")
	public R info(@PathVariable("liveId") Long liveId){
		RemindEntity remind = remindService.queryObject(liveId);
		
		return R.ok().put("remind", remind);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/remind/save")
	@RequiresPermissions("api:remind:save")
	public R save(@RequestBody RemindEntity remind){
		remindService.save(remind);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/remind/update")
	@RequiresPermissions("api:remind:update")
	public R update(@RequestBody RemindEntity remind){
		remindService.update(remind);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/remind/delete")
	@RequiresPermissions("api:remind:delete")
	public R delete(@RequestBody Long[] liveIds){
		remindService.deleteBatch(liveIds);
		
		return R.ok();
	}
	
}
