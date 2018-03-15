package com.hooview.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hooview.api.dto.CommentDTO;
import com.hooview.api.entity.FinanceInfoEntity;
import com.hooview.api.entity.InfoCommentPraiseEntity;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.InfoCommentPraiseService;
import com.hooview.api.service.MsgService;
import com.hooview.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.InfoCommentEntity;
import com.hooview.api.service.InfoCommentService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 资讯评论表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@RestController
public class InfoCommentController extends AbstractController {
	@Autowired
	private InfoCommentService infoCommentService;
	@Autowired
	private InfoCommentPraiseService infoCommentPraiseService;
	@Autowired
	private MsgService msgService;


	/**
	 * 资讯评论列表查询
	 */
	@RequestMapping("/api/financeInfo/commentlist")
//	@RequiresPermissions("api:infocomment:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CommentDTO> infoCommentList = infoCommentService.queryCommentList(query);
		if(params.get("userId") != null){
			for(CommentDTO commentDTO : infoCommentList){
				Long userId = Long.parseLong(params.get("userId").toString());
				Long infoCommentId = commentDTO.getInfoCommentId();
				InfoCommentPraiseEntity infoCommentPraiseEntity = infoCommentPraiseService.queryPraise(infoCommentId,userId);
				if(infoCommentPraiseEntity != null){
					commentDTO.setPraise(1);
				}else {
					commentDTO.setPraise(0);
				}
			}
		}else{
			for(CommentDTO commentDTO : infoCommentList){
				commentDTO.setPraise(0);
			}
		}
		int total = infoCommentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(infoCommentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("commentList", pageUtil);
	}


	/**
	 * 资讯评论
	 */
	@RequestMapping(value = "/api/financeInfo/comment",method = RequestMethod.POST)
	public R comment(@RequestBody InfoCommentEntity infoComment){
		infoCommentService.comment(infoComment);
		return R.ok();
	}

	/**
	 * 资讯评论点赞
	 */
	@RequestMapping(value = "api/financeInfo/commentpraise",method = RequestMethod.POST)
	public R praise(@RequestBody InfoCommentEntity infoComment){
		InfoCommentEntity infoCommentEntity = infoCommentService.queryObject(infoComment.getInfoCommentId());
		infoComment.setPraiseNum(1);
		infoCommentService.commentPraise(infoComment);
		InfoCommentPraiseEntity infoCommentPraise = new InfoCommentPraiseEntity();
		infoCommentPraise.setInfoCommentId(infoComment.getInfoCommentId());
		infoCommentPraise.setUserId(getUserId());
		infoCommentPraiseService.save(infoCommentPraise);
		if(!infoCommentEntity.getUserId().equals(getUserId())){
			MsgEntity msg = new MsgEntity();
			msg.setFromUserId(getUserId());
			msg.setCreateTime(new Date());
			msg.setMsgContent("赞了你的资讯评论");
			msg.setRead(0);
			msg.setToUserId(infoCommentEntity.getUserId());
			msg.setSourceId(infoComment.getInfoCommentId());
			msg.setSourceType(2);
			msgService.save(msg);
		}
		return R.ok();
	}

	/**
	 * 资讯评论点赞取消
	 */
	@RequestMapping(value = "/api/financeInfo/commentPraiseCancel",method = RequestMethod.POST )
	public R cancelPraise(@RequestBody InfoCommentEntity infoComment){
		InfoCommentPraiseEntity infoCommentPraise = new InfoCommentPraiseEntity();
		infoCommentPraise.setInfoCommentId(infoComment.getInfoCommentId());
		infoCommentPraise.setUserId(getUserId());
		infoCommentPraiseService.deletePraise(infoCommentPraise);
		infoComment.setPraiseNum(-1);
		infoCommentService.commentPraise(infoComment);
		return R.ok();
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/infoComment/info/{infoCommentId}")
	@RequiresPermissions("admin:infocomment:info")
	public R info(@PathVariable("infoCommentId") Long infoCommentId){
		InfoCommentEntity infoComment = infoCommentService.queryObject(infoCommentId);
		
		return R.ok().put("infoComment", infoComment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/infoComment/save")
	@RequiresPermissions("api:infocomment:save")
	public R save(@RequestBody InfoCommentEntity infoComment){
		infoCommentService.save(infoComment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/infoComment/update")
	@RequiresPermissions("api:infocomment:update")
	public R update(@RequestBody InfoCommentEntity infoComment){
		infoCommentService.update(infoComment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/infoComment/delete")
	@RequiresPermissions("api:infocomment:delete")
	public R delete(@RequestBody Long[] infoCommentIds){
		infoCommentService.deleteBatch(infoCommentIds);
		
		return R.ok();
	}
	
}
