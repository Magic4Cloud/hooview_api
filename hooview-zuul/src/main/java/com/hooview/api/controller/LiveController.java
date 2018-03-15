package com.hooview.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hooview.api.dto.CourseDTO;
import com.hooview.api.dto.LiveDTO;
import com.hooview.api.dto.LiveInfoDTO;
import com.hooview.api.dto.LivePlanDTO;
import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.api.entity.FansEntity;
import com.hooview.api.entity.LiveEntity;
import com.hooview.api.service.BrowseHistoryService;
import com.hooview.api.service.CollectionService;
import com.hooview.api.service.FansService;
import com.hooview.api.service.LiveService;
import com.hooview.common.redis.RedisClient;
import com.hooview.common.utils.*;
import com.hooview.easemob.service.impl.EasemobChatRoom;
import com.hooview.entity.SysUserEntity;
import com.hooview.service.SysUserService;
import io.swagger.client.model.Chatroom;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


/**
 * 直播表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class LiveController {
	@Autowired
	private LiveService liveService;
	@Autowired
	private EasemobChatRoom easemobChatRoom;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private CollectionService collectionService;
	@Autowired
	private BrowseHistoryService browseHistoryService;
	@Autowired
	private RedisClient redisClient;
	@Autowired
	private FansService fansService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/api/live/list")
	//@RequiresPermissions("api:live:list")
	public R list(@RequestParam Map<String, Object> params) throws IOException {
		//查询列表数据
		//Query query = new Query(params);
		int page = Integer.parseInt(params.get("page").toString());
		int limit = Integer.parseInt(params.get("limit").toString());
		//List<LiveEntity> liveList = getLiveList(Long.parseLong(params.get("liveTypeId").toString()),page,limit);
		List<LiveEntity> liveList = new ArrayList<>();
		//int total = liveService.queryTotal(query);
		if(params.get("keyword")!= null && !"".equals(params.get("keyword").toString().trim())){
			List<Long>  liveIds = liveService.queryByKeyword(params.get("keyword").toString().trim());
			for(Long liveId : liveIds){
				LiveEntity entity = JSON.parseObject(redisClient.get(liveId.toString()),LiveEntity.class);
				if(entity.getLiveStatus()==1){
					liveList.add(entity);
				}
			}
		}
		else if(params.get("recommend") != null && Integer.parseInt(params.get("recommend").toString())==1){
			liveList = JSON.parseArray(redisClient.get("hooview_hot"),LiveEntity.class);
		}else if(params.get("liveVip") != null && Integer.parseInt(params.get("liveVip").toString())==1){
			liveList = JSON.parseArray(redisClient.get("hooview_vip"),LiveEntity.class);
		}else{
			liveList = JSON.parseArray(redisClient.get("hooview"+params.get("liveTypeId").toString()),LiveEntity.class);
		}
		PageUtils pageUtil = new PageUtils(liveList, 50,limit, page);

		return R.ok().put("liveList", pageUtil);
	}

	/**
	 * 直播列表
	 */
	@RequestMapping("/admin/live/list")
	@RequiresPermissions("admin:live:list")
	public R adminList(@RequestParam Map<String, Object> params){
		Query query = new Query(params);
		List<LiveDTO> liveList = liveService.adminList(query);
		int total = liveService.queryAdminTotal(query);
		PageUtils pageUtil = new PageUtils(liveList, total,query.getLimit(), query.getPage());
		return R.ok().put("liveList",pageUtil);
	}

	/**
	 * 直播详情
	 */
	@RequestMapping("/admin/live/info")
	@RequiresPermissions("admin:live:info")
	public R adminInfo(@RequestParam("liveId") Long liveId){
		LiveInfoDTO live = liveService.queryObject(liveId);
		return R.ok().put("liveInfo", live);
	}
//
//	/**
//	 * 课程查询
//	 */
//	@RequestMapping("/web/live/course")
//	public R course(@RequestParam Map<String, Object> map){
//		List<LivePlanDTO> livePlans = new ArrayList<>();
//		List<CourseDTO> courses = liveService.queryCourse(map);
//
//	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/api/live/info")
	public R info(@RequestParam("liveId") Long liveId,@RequestParam("userId") Long userId){
		LiveInfoDTO live = liveService.queryObject(liveId);
		if(userId != null){
			Long collectionId = collectionService.queryUserFollow(live.getLiveId(),userId,0);
			if(collectionId != null && collectionId > 0){
				live.setCollection(1);
			}else{
				live.setCollection(0);
			}
			Map<String ,Object> map = new HashMap<>();
			map.put("userId",live.getUserId());
			map.put("fansUserId",userId);
			FansEntity fansEntity = fansService.getFollow(map);
			if(fansEntity != null){
				live.setFollow(1);
			}else {
				live.setFollow(0);
			}
			BrowseHistoryEntity browseHistory = new BrowseHistoryEntity();
			browseHistory.setUserId(userId);
			browseHistory.setCreateTime(new Date());
			browseHistory.setSourceId(liveId);
			browseHistory.setSourceType(0);
			browseHistoryService.save(browseHistory);
		}else{
			live.setFollow(0);
		}

		return R.ok().put("liveInfo", live);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/admin/live/save")
	@RequiresPermissions("admin:live:save")
	public R save(@RequestBody LiveEntity live){
		SysUserEntity user = sysUserService.queryObject(live.getUserId());
		//创建环信聊天室
		Chatroom chatroom = new Chatroom();
		chatroom.name(live.getLiveTitle()).description(live.getLiveTitle()).maxusers(5000).owner(user.getMobile());
		Object huanxinResult = easemobChatRoom.createChatRoom(chatroom);
		JSONObject result = JSON.parseObject(huanxinResult.toString());
		String roomId=result.getJSONObject("data").getString("id");
		live.setWatchCount(0);
		live.setLikeCount(0);
		live.setCreateTime(new Date());
		live.setWatchingCount(0);
		live.setRoomId(roomId);
		liveService.save(live);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/admin/live/update",method = RequestMethod.POST)
	@RequiresPermissions("admin:live:update")
	public R update(@RequestBody LiveEntity live){
		liveService.update(live);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/admin/live/delete",method = RequestMethod.POST)
	@RequiresPermissions("api:live:delete")
	public R delete(@RequestBody Map<String, Object> map){
		liveService.deleteBatch(map);
		map.put("sourceType",0);
		map.put("sourceIds",map.get("liveIds"));
		browseHistoryService.deleteSource(map);
		collectionService.deleteSource(map);
		
		return R.ok();
	}

	/**
	 * 直播查询方法（临时方案）
	 * 调用易直播的提供的接口直接查询
	 * 获取到的数据循环取得聊天室id
	 * 聊天室id为空的创建聊天室并与直播间关联
	 *
	 */

	public List<LiveEntity> getLiveList(Long liveTypeId,int page,int limit ) throws IOException {
		//获取直播列表
		List<LiveEntity> liveList = new ArrayList<>();
		String url="https://dev.yizhibo.tv/dev/appgw/hooviewvideolist?start="+page+"&count="+limit+"&topicid="+liveTypeId;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpResponse response = HttpUtil.excuteHttpGet(httpclient,url);
		String res = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject resJson = JSON.parseObject(res);
		if(null==resJson.getString("retval") || !"ok".equals(resJson.getString("retval"))){
			return liveList;
		}else {
			JSONArray resLiveList = resJson.getJSONObject("retinfo").getJSONArray("videos");
			//循环直播列表
			for(int i = 0;i<resLiveList.size();i++){
				JSONObject resObj = resLiveList.getJSONObject(i);
				LiveEntity entity = new LiveEntity();
				String vid = resObj.getString("vid");
				String title = resObj.getString("title");
				entity.setVid(vid);
				entity.setUserId(1L);
				entity.setLiveTitle(title);
				entity.setLiveTypeId(liveTypeId);
				entity.setLiveVip(Integer.parseInt(resObj.getString("vip")));
				entity.setRecommend(0);
				entity.setCreateTime(DateUtils.dateFormat(resObj.getString("live_start_time")));
				//获取聊天室id
				LiveEntity roomEntity = liveService.queryByVid(vid);
				//roomId为空则生成room
				if(null==roomEntity){
					Chatroom chatroom = new Chatroom();
					chatroom.name(title).description(title).maxusers(5000).owner("hooview_test");
					Object huanxinResult = easemobChatRoom.createChatRoom(chatroom);
					JSONObject result = JSON.parseObject(huanxinResult.toString());
					String roomId=result.getJSONObject("data").getString("id");
					entity.setRoomId(roomId);
					liveService.save(entity);
				}else{
					entity.setRoomId(roomEntity.getRoomId());
				}

				entity.setLivePrice(new BigDecimal(0.0d));
				entity.setLiveStatus(resObj.getInteger("living"));
				entity.setWatchCount(resObj.getInteger("watch_count"));
				entity.setLikeCount(resObj.getInteger("like_count"));
				entity.setWatchingCount(resObj.getInteger("watching_count"));
				entity.setDuration(resObj.getInteger("duration"));
				entity.setLiveStopTime(DateUtils.dateFormat(resObj.getString("live_stop_time")));
				entity.setLocation(resObj.getString("location"));
				entity.setLogourl(resObj.getString("logo_thumb"));
				liveList.add(entity);
			}
			return liveList;
		}
	}
}
