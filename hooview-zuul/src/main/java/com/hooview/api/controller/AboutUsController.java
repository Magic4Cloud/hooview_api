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

import com.hooview.api.entity.AboutUsEntity;
import com.hooview.api.service.AboutUsService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 关于表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class AboutUsController {
	@Autowired
	private AboutUsService aboutUsService;


	/**
	 * 关于我们
	 */
	@RequestMapping("/api/aboutUs/info")
	public R info(){
		AboutUsEntity aboutUs = aboutUsService.queryObject();
		return R.ok().put("aboutUs",aboutUs.getAboutUs());
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/admin/aboutUs/update")
	@RequiresPermissions("admin:aboutus:update")
	public R update(@RequestBody AboutUsEntity aboutUs){
		aboutUsService.update(aboutUs);
		
		return R.ok();
	}
	
}
