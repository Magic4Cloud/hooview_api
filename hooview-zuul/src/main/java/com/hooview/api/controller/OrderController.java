package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import com.hooview.api.dto.orderDTO;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hooview.api.entity.OrderEntity;
import com.hooview.api.service.OrderService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 订单表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class OrderController extends AbstractController{
	@Autowired
	private OrderService orderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/user/myorder")
	public R list(@RequestParam Map<String, Object> params){

		Long userId =  Long.parseLong(params.get("userId").toString());
		if(!userId.equals(getUserId())){
			return R.error(400,"请求参数缺失或错误");
		}
		//查询列表数据
        Query query = new Query(params);

		List<orderDTO> orderList = orderService.queryList(query);
		int total = orderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("orderList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/api/user/orderInfo")
	public R info(@RequestParam Map<String, Object> map){
		Long userId =  Long.parseLong(map.get("userId").toString());
		if(!userId.equals(getUserId())){
			return R.error(400,"请求参数缺失或错误");
		}
		orderDTO order = orderService.queryObject(map);
		return R.ok().put("orderInfo", order);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/order/save")
	@RequiresPermissions("api:order:save")
	public R save(@RequestBody OrderEntity order){
		orderService.save(order);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/order/update")
	@RequiresPermissions("api:order:update")
	public R update(@RequestBody OrderEntity order){
		orderService.update(order);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/order/delete")
	@RequiresPermissions("api:order:delete")
	public R delete(@RequestBody Long[] orderIds){
		orderService.deleteBatch(orderIds);
		
		return R.ok();
	}
	
}
