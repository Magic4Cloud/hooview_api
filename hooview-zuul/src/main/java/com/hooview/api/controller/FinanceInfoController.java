package com.hooview.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hooview.api.dto.*;
import com.hooview.api.entity.*;
import com.hooview.api.service.*;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 财经资讯表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class FinanceInfoController extends AbstractController {
	@Autowired
	private FinanceInfoService financeInfoService;
	@Autowired
    private CollectionService collectionService;
	@Autowired
	private FinancePraiseService financePraiseService;
	@Autowired
	private BrowseHistoryService browseHistoryService;
	@Autowired
	private FansService fansService;
	@Autowired
	private MsgService msgService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/api/financeinfo/list",method = RequestMethod.GET)
//	@RequiresPermissions("api:financeinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FinanceDTO> financeList = financeInfoService.queryFinanceList(query);
		int total = financeInfoService.queryFinanceTotal(query);
		
		PageUtils pageUtil = new PageUtils(financeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("financeList", pageUtil);
	}

	/**
	 * 资讯列表
	 */
	@RequestMapping(value = "/admin/financeinfo/list",method = RequestMethod.GET)
	@RequiresPermissions("admin:financeinfo:list")
	public R adminList(@RequestParam Map<String, Object> params){
		Query query = new Query(params);
		List<AdminFinanceDTO> financeList = financeInfoService.queryAdminFinanceList(query);
		int total = financeInfoService.queryFinanceTotal(query);

		PageUtils pageUtil = new PageUtils(financeList, total, query.getLimit(), query.getPage());

		return R.ok().put("financeList", pageUtil);
	}

	/**
	 * 资讯点赞
	 */
	@RequestMapping(value = "/api/financeInfo/praise",method = RequestMethod.POST )
	public R praise(@RequestBody FinanceInfoEntity financeInfoEntity){
		FinanceInfoEntity infoEntity = financeInfoService.queryObject(financeInfoEntity.getFinanceInfoId());
		financeInfoEntity.setPraiseNum(1);
		financeInfoService.praise(financeInfoEntity);
		FinancePraiseEntity entity = new FinancePraiseEntity();
		entity.setFinanceInfoId(financeInfoEntity.getFinanceInfoId());
		entity.setUserId(getUserId());
		financePraiseService.save(entity);
		if(!infoEntity.getCreateUserId().equals(getUserId())){
			MsgEntity msg = new MsgEntity();
			msg.setFromUserId(getUserId());
			msg.setCreateTime(new Date());
			msg.setMsgContent("赞了你的资讯");
			msg.setRead(0);
			msg.setToUserId(infoEntity.getCreateUserId());
			msg.setSourceId(financeInfoEntity.getFinanceInfoId());
			msg.setSourceType(1);
			msgService.save(msg);
		}
		return R.ok();
	}

	/**
	 * 取消资讯点赞
	 */
	@RequestMapping(value = "/api/financeInfo/cancelPraise",method = RequestMethod.POST )
	public R cancelPraise(@RequestBody FinanceInfoEntity financeInfoEntity){
		FinancePraiseEntity entity = new FinancePraiseEntity();
		entity.setFinanceInfoId(financeInfoEntity.getFinanceInfoId());
		entity.setUserId(getUserId());
		financePraiseService.deletePraise(entity);
		financeInfoEntity.setPraiseNum(-1);
		financeInfoService.praise(financeInfoEntity);
		return R.ok();
	}


	
	/**
	 * 信息
	 */
	@RequestMapping("/api/financeinfo/info")
	public R info(@RequestParam("financeInfoId") Long financeInfoId,@RequestParam(value = "userId",required = false) Long userId){
		FinanceInfoDTO financeInfo = financeInfoService.queryFinanceInfo(financeInfoId);
		String keyword ="";
		if(financeInfo.getKeyword() != null){
			keyword=financeInfo.getKeyword().split(",")[0];
		}
		List<RecommendDTO> recommendList = financeInfoService.queryRecommendList(keyword);
		financeInfo.setRecommendList(recommendList);
        if(userId != null){
            Long collectionId = collectionService.queryUserFollow(financeInfo.getFinanceInfoId(),userId,1);
            if(collectionId != null && collectionId > 0){
                financeInfo.setCollection(1);
            }else {
				financeInfo.setCollection(0);
			}
            FinancePraiseEntity entity = financePraiseService.queryPraise(financeInfoId,userId);
            if(entity!= null){
                financeInfo.setPraise(1);
            }else {
				financeInfo.setPraise(0);
			}
            Map<String ,Object> map = new HashMap<>();
            map.put("userId",financeInfo.getUserId());
            map.put("fansUserId",userId);
			FansEntity fansEntity = fansService.getFollow(map);
            if(fansEntity != null){
				financeInfo.setFollow(1);
			}else {
				financeInfo.setFollow(0);
			}

			BrowseHistoryEntity browseHistory = new BrowseHistoryEntity();
			browseHistory.setUserId(userId);
			browseHistory.setCreateTime(new Date());
			browseHistory.setSourceId(financeInfoId);
			browseHistory.setSourceType(1);
			browseHistoryService.save(browseHistory);
        }else{
            financeInfo.setFollow(0);
            financeInfo.setPraise(0);
            financeInfo.setCollection(0);
        }

		return R.ok().put("financeInfo", financeInfo);
	}

	/**
	 * 资讯详情
	 */
	@RequestMapping(value = "/admin/financeinfo/info",method = RequestMethod.GET)
	@RequiresPermissions("admin:financeinfo:info")
	public R adminInfo(@RequestParam("financeInfoId") Long financeInfoId){
		AdminFinanceInfoDTO FinanceInfo = financeInfoService.queryAdminFinanceInfo(financeInfoId);
		return R.ok().put("financeInfo",FinanceInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/admin/financeInfo/save")
	@RequiresPermissions("admin:financeinfo:save")
	public R save(@RequestBody FinanceInfoEntity financeInfo){
		financeInfo.setStatus(1);
		financeInfo.setType(1);
		financeInfo.setCreateUserId(getUserId());
		financeInfo.setPraiseNum(0);
		financeInfo.setCreateTime(new Date());
		financeInfoService.save(financeInfo);
		return R.ok();
	}
	
	/**
	 * 资讯编辑
	 */
	@RequestMapping(value = "/admin/financeinfo/update",method = RequestMethod.POST)
	@RequiresPermissions("admin:financeinfo:update")
	public R update(@RequestBody FinanceInfoEntity financeInfo){
		financeInfoService.update(financeInfo);
		
		return R.ok();
	}
	
	/**
	 * 资讯删除
	 */
	@RequestMapping(value = "/admin/financeinfo/delete",method = RequestMethod.POST)
	@RequiresPermissions("admin:financeinfo:delete")
	public R delete(@RequestBody Map<String,Object> map){
		financeInfoService.deleteBatch(map);
		map.put("sourceType",1);
		map.put("sourceIds",map.get("financeInfoIds"));
		browseHistoryService.deleteSource(map);
		collectionService.deleteSource(map);
		return R.ok();
	}
	
}
