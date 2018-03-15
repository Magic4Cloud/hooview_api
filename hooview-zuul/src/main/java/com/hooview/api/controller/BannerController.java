package com.hooview.api.controller;

import com.hooview.api.dto.BannerDTO;
import com.hooview.api.entity.BannerEntity;
import com.hooview.api.service.BannerService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




/**
 * 轮播图表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/banner/list")
	//@RequiresPermissions("api:banner:list")
	public R list(@RequestParam Map<String, Object> params){

		List<BannerEntity> bannerList = bannerService.queryList(params);
		
		return R.ok().put("bannerList", bannerList);
	}

	/**
	 * 轮播图排序、设置上下线
	 */
	@RequestMapping("/admin/banner/order")
	@RequiresPermissions("admin:banner:list")
	public R bannerOrder(@RequestBody BannerDTO banner){
			bannerService.bannerOrder(banner);
			return R.ok();
	}
	/**
	 * 轮播图查询
	 */
	@RequestMapping("/admin/banner/list")
	@RequiresPermissions("admin:banner:list")
	public R adminList(@RequestParam Map<String, Object> params){

		List<BannerDTO> bannerList = bannerService.queryAdminList(params);

		return R.ok().put("bannerList", bannerList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/banner/info/{id}")
	@RequiresPermissions("api:banner:info")
	public R info(@PathVariable("id") Long id){
		BannerEntity banner = bannerService.queryObject(id);
		
		return R.ok().put("banner", banner);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/banner/save")
	@RequiresPermissions("api:banner:save")
	public R save(@RequestBody BannerEntity banner){
		bannerService.save(banner);
		
		return R.ok();
	}
	
	/**
	 * 轮播图新增/编辑
	 */
	@RequestMapping(value = "/admin/banner/saveOrUpdate",method = RequestMethod.POST)
	@RequiresPermissions("admin:banner:update")
	public R update(@RequestBody BannerDTO banner){
		bannerService.update(banner);
		
		return R.ok();
	}

	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/admin/banner/delete",method = RequestMethod.POST)
	@RequiresPermissions("admin:banner:delete")
	public R delete(@RequestBody Map<String, Object> map){
		bannerService.deleteBatch(map);
		
		return R.ok();
	}
	
}
