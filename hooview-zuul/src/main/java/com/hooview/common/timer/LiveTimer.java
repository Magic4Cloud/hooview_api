package com.hooview.common.timer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hooview.api.dto.HotLiveDTO;
import com.hooview.api.dto.UserDTO;
import com.hooview.api.entity.LiveEntity;
import com.hooview.api.entity.LiveTypeEntity;
import com.hooview.api.service.LiveService;
import com.hooview.api.service.LiveTypeService;
import com.hooview.api.service.MuteService;
import com.hooview.common.redis.RedisClient;
import com.hooview.common.utils.DateUtils;
import com.hooview.common.utils.HttpUtil;
import com.hooview.easemob.service.impl.EasemobChatRoom;
import com.hooview.service.SysUserService;
import io.swagger.client.model.Chatroom;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.util.resources.ga.LocaleNames_ga;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @auther lee
 * @createTime 2018年01月31日 15时32分
 * @discription
 */
@Component
public class LiveTimer {
    @Autowired
    private LiveService liveService;
    @Autowired
    private EasemobChatRoom easemobChatRoom;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private LiveTypeService liveTypeService;
    @Autowired
    private MuteService muteService;

    // 间隔3分钟,执行拉取直播列表任务
    @Scheduled(cron="0 0/3 * * * ?")
    public void executeUploadLiveTask() throws IOException {
        JSONArray vipLiveArray = new JSONArray();
        for(long liveTypeId=141;liveTypeId<=145;liveTypeId++){
            LiveTypeEntity  liveTypeEntity = liveTypeService.queryObject((int)liveTypeId);
            String url="https://dev.yizhibo.tv/dev/appgw/hooviewvideolist?start="+0+"&count="+50+"&topicid="+liveTypeId;
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpResponse response = HttpUtil.excuteHttpGet(httpclient,url);
            String res = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject resJson = JSON.parseObject(res);
            if(null==resJson.getString("retval") || !"ok".equals(resJson.getString("retval"))){
                continue;
            }else {
                JSONArray resLiveList = resJson.getJSONObject("retinfo").getJSONArray("videos");
                //获取直播列表
                JSONArray liveList = new JSONArray();
                //循环直播列表
                for(int i = 0;i<resLiveList.size();i++){
                    JSONObject resObj = resLiveList.getJSONObject(i);
                    String vid = resObj.getString("vid");
                    String title = resObj.getString("title");
                    LiveEntity entity = liveService.queryByVid(vid);
                    if(entity==null) {
                        entity = new LiveEntity();
                    }
                    entity.setLiveTitle(title);
                    entity.setLiveTypeId(liveTypeId);
                    entity.setLiveTypeName(liveTypeEntity.getTypeName());
                    entity.setLiveStatus(resObj.getInteger("living"));
                    entity.setWatchCount(resObj.getInteger("watch_count"));
                    entity.setLikeCount(resObj.getInteger("like_count"));
                    entity.setWatchingCount(resObj.getInteger("watching_count"));
                    entity.setDuration(resObj.getInteger("duration"));
                    entity.setLiveStopTime(DateUtils.dateFormat(resObj.getString("live_stop_time")));
                    entity.setLocation(resObj.getString("location"));
                    entity.setLogourl(resObj.getString("logo_thumb"));
                    String yiId = resObj.getString("name");
                    UserDTO userDTO = sysUserService.queryByYiId(yiId);
                    if(entity.getLiveId()==null) {

                        entity.setVid(vid);
                        entity.setLiveVip(0);
                        entity.setRecommend(0);
                        entity.setCreateTime(DateUtils.dateFormat(resObj.getString("live_start_time")));
                        //生成room
                        Chatroom chatroom = new Chatroom();
                        //当直播的yiId对应有主播的时候加上关联关系
                        if(userDTO != null){
                            entity.setUserId(userDTO.getUserId());
                            chatroom.name(title).description(title).maxusers(5000).owner(userDTO.getMobile());
                        }else{
                            entity.setUserId(1L);
                            chatroom.name(title).description(title).maxusers(5000).owner("hooview_test");
                        }
                        Object huanxinResult = easemobChatRoom.createChatRoom(chatroom);
                        JSONObject result = JSON.parseObject(huanxinResult.toString());
                        String roomId=result.getJSONObject("data").getString("id");
                        entity.setRoomId(roomId);
                        entity.setLivePrice(new BigDecimal(0.0d));
                        liveService.save(entity);
                        entity.setLiveId(liveService.queryLiveId(vid));
                    }else {
                        if(userDTO != null && !userDTO.getUserId().equals(entity.getUserId())){
                            //先删除聊天室
                            easemobChatRoom.deleteChatRoom(entity.getRoomId());
                            Map<String,Object> map = new HashMap<>();
                            map.put("chatRoomId",entity.getRoomId());
                            muteService.delete(map);
                            //重新生成聊天室
                            Chatroom chatroom = new Chatroom();
                            entity.setUserId(userDTO.getUserId());
                            chatroom.name(title).description(title).maxusers(5000).owner(userDTO.getMobile());
                            Object huanxinResult = easemobChatRoom.createChatRoom(chatroom);
                            JSONObject result = JSON.parseObject(huanxinResult.toString());
                            String roomId=result.getJSONObject("data").getString("id");
                            entity.setRoomId(roomId);
                        }
                        liveService.update(entity);
                    }
                    JSONObject liveObj = (JSONObject) JSON.toJSON(entity);
                    redisClient.set(entity.getLiveId().toString(),liveObj.toString());

                    //仅当是正在直播的才放入对应列表
                    if(entity.getLiveStatus()==1) {
                        //vip直播
                        if(entity.getLiveVip()==1) {
                            vipLiveArray.add(liveObj);
                        }
                        liveList.add(liveObj);
                    }
                }
                redisClient.set("hooview"+liveTypeId,liveList.toJSONString());
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("limit",100);
        map.put("recommend",1);
        List<LiveEntity> hooviewHotList = liveService.queryList(map);
        redisClient.set("hooview_hot",JSON.toJSONString(hooviewHotList));
        redisClient.set("hooview_vip",vipLiveArray.toString());
    }
}
