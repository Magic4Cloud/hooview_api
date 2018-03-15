package com.hooview.api.controller;

import com.hooview.api.dto.FinanceCollectionDTO;
import com.hooview.api.dto.LiveCollectionDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.entity.CollectionEntity;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.CollectionService;
import com.hooview.api.service.FinanceInfoService;
import com.hooview.api.service.LiveService;
import com.hooview.api.service.MsgService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;




/**
 * 用户收藏表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class CollectionController extends AbstractController{
	@Autowired
	private CollectionService collectionService;
	@Autowired
	private MsgService msgService;
	@Autowired
	private LiveService liveService;
	@Autowired
	private FinanceInfoService financeInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/collection/live")
	public R list(@RequestParam Map<String, Object> params){

		params.put("userId",getUserId());
		//查询列表数据
        Query query = new Query(params);

		List<LiveCollectionDTO> collectionList = collectionService.queryList(query);
		int total = collectionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collectionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("liveCollectionList", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/collection/info/{collectionId}")
	@RequiresPermissions("api:collection:info")
	public R info(@PathVariable("collectionId") Long collectionId){
		CollectionEntity collection = collectionService.queryObject(collectionId);
		
		return R.ok().put("collection", collection);
	}

	/**
	 * 获取我的财经收藏
	 */
	@RequestMapping(value = "api/collection/finance",method = RequestMethod.GET)
	public R finance(@RequestParam Map<String, Object> params){

		params.put("userId",getUserId());
		//查询列表数据
		Query query = new Query(params);

		List<FinanceCollectionDTO> collectionList = collectionService.queryFinanceList(query);
		int total = collectionService.queryFinanceTotal(query);

		PageUtils pageUtil = new PageUtils(collectionList, total, query.getLimit(), query.getPage());

		return R.ok().put("collectionList", pageUtil);

	}

	
	/**
	 * 用户收藏
	 */
	@RequestMapping("/api/collection/add")
	public R save(@RequestBody CollectionEntity collection){
		collection.setCreateTime(new Date());
		collectionService.save(collection);
		MsgEntity msg = new MsgEntity();
		msg.setSourceId(collection.getSourceId());
		msg.setFromUserId(getUserId());
		msg.setCreateTime(new Date());
		msg.setRead(0);
		//直播
		if(0==collection.getSourceType()){
			LiveInfoDTO liveEntity = liveService.queryObject(collection.getSourceId());
			msg.setMsgContent("收藏了你的直播");
			msg.setToUserId(liveEntity.getUserId());
			msg.setSourceType(0);
			msgService.save(msg);
		}else if(1==collection.getSourceType()) {
			FinanceInfoEntity infoEntity = financeInfoService.queryObject(collection.getSourceId());
			msg.setMsgContent("收藏了你的资讯");
			msg.setToUserId(infoEntity.getCreateUserId());
			msg.setSourceType(1);
			msgService.save(msg);
		}
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/collection/update")
	@RequiresPermissions("api:collection:update")
	public R update(@RequestBody CollectionEntity collection){
		collectionService.update(collection);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
//	@RequestMapping(value = "/api/collection/delete",method = RequestMethod.POST)
//	public R delete(@RequestBody Map<String,Object> map){
//		map.put("userId",getUserId());
//		collectionService.deleteBatch(map);
//		return R.ok();
//	}

	/**
	 * 删除收藏
	 */
	@RequestMapping(value = "/api/collection/delete",method = RequestMethod.POST)
	public R delete(@RequestBody Map<String,Object> map){
		map.put("userId",getUserId());
		collectionService.delete(map);
		return R.ok();
	}
	
}
