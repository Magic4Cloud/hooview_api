package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.OpenApplyEntity;
import com.hooview.api.service.OpenApplyService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 开户申请表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class OpenApplyController {
	@Autowired
	private OpenApplyService openApplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/admin/apply/list",method = RequestMethod.GET)
	@RequiresPermissions("admin:openapply:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OpenApplyEntity> openApplyList = openApplyService.queryList(query);
		int total = openApplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(openApplyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("openApplyList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/openApply/info/{openApplyId}")
	@RequiresPermissions("api:openapply:info")
	public R info(@PathVariable("openApplyId") Long openApplyId){
		OpenApplyEntity openApply = openApplyService.queryObject(openApplyId);
		
		return R.ok().put("openApply", openApply);
	}
	
	/**
	 * 开户申请
	 */
	@RequestMapping("/api/apply/open")
	public R save(@RequestBody OpenApplyEntity openApply){

		//先检查是否已经申请过
		OpenApplyEntity oldEntity = openApplyService.queryByMobile(openApply.getMobile());
		if(oldEntity != null){
			return R.error(1,"已提交过申请，请等待审核");
		}
		openApply.setStatus(1);
		openApplyService.save(openApply);
		return R.ok();
	}
	
	/**
	 * 审核开户申请
	 */
	@RequestMapping(value = "/admin/apply/audit",method = RequestMethod.POST)
	@RequiresPermissions("admin:openapply:update")
	public R update(@RequestBody OpenApplyEntity openApply){
		openApplyService.update(openApply);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/openApply/delete")
	@RequiresPermissions("api:openapply:delete")
	public R delete(@RequestBody Long[] openApplyIds){
		openApplyService.deleteBatch(openApplyIds);
		
		return R.ok();
	}
	
}
