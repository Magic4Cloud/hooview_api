package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import com.hooview.api.dto.MsgDTO;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.MsgService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 消息表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class MsgController extends AbstractController {
	@Autowired
	private MsgService msgService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/user/msg")
	public R list(@RequestParam Map<String, Object> params){
		params.put("userId",getUserId());
		//查询列表数据
        Query query = new Query(params);

		List<MsgDTO> msgList = msgService.queryMyList(query);
		int total = msgService.queryMyTotal(query);
		
		PageUtils pageUtil = new PageUtils(msgList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("messageList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/msg/info/{msgId}")
	@RequiresPermissions("api:msg:info")
	public R info(@PathVariable("msgId") Long msgId){
		MsgEntity msg = msgService.queryObject(msgId);
		
		return R.ok().put("msg", msg);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/msg/save")
	@RequiresPermissions("api:msg:save")
	public R save(@RequestBody MsgEntity msg){
		msgService.save(msg);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/msg/update")
	@RequiresPermissions("api:msg:update")
	public R update(@RequestBody MsgEntity msg){
		msgService.update(msg);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/api/msg/delete")
	//@RequiresPermissions("api:msg:delete")
	public R delete(@RequestBody Long[] msgIds){
		msgService.deleteBatch(msgIds);
		
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/api/user/deleteMsg",method = RequestMethod.POST)
	//@RequiresPermissions("api:msg:delete")
	public R deleteMsg(@RequestBody MsgEntity msgEntity){
		msgEntity.setToUserId(getUserId());
		msgService.deleteMyBatch(msgEntity);

		return R.ok();
	}
	
}
