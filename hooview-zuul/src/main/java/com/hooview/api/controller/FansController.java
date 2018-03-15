package com.hooview.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hooview.api.dto.FansDTO;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.MsgService;
import com.hooview.controller.AbstractController;
import com.hooview.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.FansEntity;
import com.hooview.api.service.FansService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 用户粉丝表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class FansController extends AbstractController{
	@Autowired
	private FansService fansService;
	
	/**
	 * 获取我的关注
	 */
	@RequestMapping("/api/user/myfollow")
	public R list(@RequestParam Map<String, Object> params){

		//查询列表数据
        Query query = new Query(params);
		query.put("userId",getUserId());
		List<FansDTO> fansList = fansService.queryList(query);
		int total = fansService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(fansList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("myFollowList", pageUtil);
	}

	/**
	 * 获取我的粉丝
	 */
	@RequestMapping("/api/user/myfans")
	public R fansList(@RequestParam Map<String, Object> params){

		//查询列表数据
		Query query = new Query(params);
		query.put("userId",getUserId());
		List<FansDTO> fansList = fansService.queryFansList(query);
		int total = fansService.queryFansTotal(query);

		PageUtils pageUtil = new PageUtils(fansList, total, query.getLimit(), query.getPage());

		return R.ok().put("myFansList", pageUtil);
	}

	/**
	 * 关注
	 */
	@RequestMapping(value = "/api/user/follow",method = RequestMethod.POST)
	public R follow(@RequestBody FansEntity user){
		user.setFansUserId(getUserId());
		fansService.follow(user);
		return R.ok();
	}

	/**
	 * 取消关注
	 */
	@RequestMapping(value = "/api/user/deleteFollow",method = RequestMethod.POST)
	public R deleteFollow(@RequestBody FansEntity user){
		user.setFansUserId(getUserId());
		fansService.deleteFollow(user);
		return R.ok();
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/fans/info/{userId}")
	@RequiresPermissions("api:fans:info")
	public R info(@PathVariable("userId") Long userId){
		FansEntity fans = fansService.queryObject(userId);
		
		return R.ok().put("fans", fans);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/fans/save")
	public R save(@RequestBody FansEntity fans){
		fansService.save(fans);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/fans/update")
	@RequiresPermissions("api:fans:update")
	public R update(@RequestBody FansEntity fans){
		fansService.update(fans);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/fans/delete")
	@RequiresPermissions("api:fans:delete")
	public R delete(@RequestBody Long[] userIds){
		fansService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
