package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import com.hooview.api.dto.OpinionDTO;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hooview.api.entity.OpinionEntity;
import com.hooview.api.service.OpinionService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 意见反馈表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class OpinionController extends AbstractController{
	@Autowired
	private OpinionService opinionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/admin/opinion/list")
	@RequiresPermissions("admin:opinion:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OpinionDTO> opinionList = opinionService.queryByList(query);
		int total = opinionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(opinionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("opinionList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/opinion/info/{opinionId}")
	@RequiresPermissions("api:opinion:info")
	public R info(@PathVariable("opinionId") Long opinionId){
		OpinionEntity opinion = opinionService.queryObject(opinionId);
		
		return R.ok().put("opinion", opinion);
	}
	
	/**
	 * 意见反馈
	 */
	@RequestMapping("/api/user/opinion")
	public R save(@RequestBody OpinionEntity opinion){

		opinion.setUserId(getUserId());
		opinionService.save(opinion);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/admin/opinion/update")
	@RequiresPermissions("admin:opinion:update")
	public R update(@RequestBody OpinionEntity opinion){
		opinionService.update(opinion);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/opinion/delete")
	@RequiresPermissions("api:opinion:delete")
	public R delete(@RequestBody Long[] opinionIds){
		opinionService.deleteBatch(opinionIds);
		
		return R.ok();
	}
	
}
