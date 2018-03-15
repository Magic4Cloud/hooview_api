package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import com.hooview.api.dto.HistoryDTO;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.api.service.BrowseHistoryService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 用户浏览历史表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class BrowseHistoryController extends AbstractController{
	@Autowired
	private BrowseHistoryService browseHistoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/user/history")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		params.put("userId",getUserId());
		List<HistoryDTO> browseHistoryList = browseHistoryService.queryList(query);
		int total = browseHistoryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(browseHistoryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("historyList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/browseHistory/info/{browseHistoryId}")
	@RequiresPermissions("api:browsehistory:info")
	public R info(@PathVariable("browseHistoryId") Long browseHistoryId){
		BrowseHistoryEntity browseHistory = browseHistoryService.queryObject(browseHistoryId);
		
		return R.ok().put("browseHistory", browseHistory);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/browseHistory/save")
	@RequiresPermissions("api:browsehistory:save")
	public R save(@RequestBody BrowseHistoryEntity browseHistory){
		browseHistoryService.save(browseHistory);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/browseHistory/update")
	@RequiresPermissions("api:browsehistory:update")
	public R update(@RequestBody BrowseHistoryEntity browseHistory){
		browseHistoryService.update(browseHistory);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/api/user/deleteHistory")
	public R delete(@RequestBody BrowseHistoryEntity browseHistory){
		browseHistory.setUserId(getUserId());
		browseHistoryService.deleteBatch(browseHistory);
		
		return R.ok();
	}
	
}
