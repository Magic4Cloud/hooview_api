package com.hooview.api.service.impl;

import com.hooview.api.dto.CommentDTO;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hooview.api.dao.InfoCommentDao;
import com.hooview.api.entity.InfoCommentEntity;
import com.hooview.api.service.InfoCommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Service("infoCommentService")
public class InfoCommentServiceImpl implements InfoCommentService {
	@Autowired
	private InfoCommentDao infoCommentDao;
	
	@Override
	public InfoCommentEntity queryObject(@RequestBody Long infoCommentId){
		return infoCommentDao.queryObject(infoCommentId);
	}
	
	@Override
	public List<InfoCommentEntity> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return infoCommentDao.queryList(query);
	}
	
	@Override
	public int queryTotal(@RequestParam Map<String, Object> map){
		return infoCommentDao.queryTotal(map);
	}
	
	@Override
	public void save(InfoCommentEntity infoComment){
		infoCommentDao.save(infoComment);
	}

	@Override
	public void commentPraise(@RequestBody InfoCommentEntity infoComment) {
		infoCommentDao.commentPraise(infoComment);
	}

	@Override
	public void comment(@RequestBody InfoCommentEntity infoComment) {
		infoCommentDao.comment(infoComment);
	}

	@Override
	public void update(InfoCommentEntity infoComment){
		infoCommentDao.update(infoComment);
	}
	
	@Override
	public void delete(Long infoCommentId){
		infoCommentDao.delete(infoCommentId);
	}
	
	@Override
	public void deleteBatch(Long[] infoCommentIds){
		infoCommentDao.deleteBatch(infoCommentIds);
	}

	public List<CommentDTO> queryCommentList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return infoCommentDao.queryCommentList(query);
	}

}
