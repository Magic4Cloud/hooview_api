package com.hooview.api.service;

import com.hooview.api.dto.CommentDTO;
import com.hooview.api.entity.InfoCommentEntity;
import com.hooview.api.service.impl.InfoCommentServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 资讯评论表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = InfoCommentServiceBack.class)
public interface InfoCommentService {

	@RequestMapping(value="/infoComment/queryObject",method = RequestMethod.POST)
	InfoCommentEntity queryObject(@RequestBody Long infoCommentId);

	@RequestMapping(value="/infoComment/queryList",method = RequestMethod.GET)
	List<InfoCommentEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/infoComment/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/infoComment/save",method = RequestMethod.POST)
	void save(InfoCommentEntity infoComment);

	@RequestMapping(value="/financeInfo/commentpraise",method = RequestMethod.POST)
	void commentPraise(@RequestBody InfoCommentEntity infoComment);

	@RequestMapping(value="/financeInfo/comment",method = RequestMethod.POST)
	void comment(@RequestBody InfoCommentEntity infoComment);


	@RequestMapping(value="/infoComment/update",method = RequestMethod.POST)
	void update(InfoCommentEntity infoComment);

	@RequestMapping(value="/infoComment/delete",method = RequestMethod.POST)
	void delete(Long infoCommentId);

	@RequestMapping(value="/infoComment/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] infoCommentIds);

	@RequestMapping(value="/infoComment/queryCommentList",method = RequestMethod.GET)
	List<CommentDTO> queryCommentList(@RequestParam  Map<String, Object> map);
}
