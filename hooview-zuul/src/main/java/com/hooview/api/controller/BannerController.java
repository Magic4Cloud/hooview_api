package com.hooview.api.controller;

import com.hooview.api.service.BannerService;
import com.hooview.common.utils.AjaxMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * banner表
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
	 * 获取banner
	 */
	@RequestMapping("/api/banner/")
	@ResponseBody
	public AjaxMsg info(){
		AjaxMsg ajaxMsg=new AjaxMsg();
		Map<String,Object> map=new HashMap<>();
		List list=bannerService.queryList(map);
		ajaxMsg.setCode(AjaxMsg.SUCCESS);
		ajaxMsg.setDatas(list);
		ajaxMsg.setMessage("获取列表成功");
		return  ajaxMsg;
	}

}
