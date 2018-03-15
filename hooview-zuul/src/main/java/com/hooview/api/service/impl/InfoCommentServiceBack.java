package com.hooview.api.service.impl;

import com.hooview.api.dto.CommentDTO;
import com.hooview.api.entity.InfoCommentEntity;
import com.hooview.api.service.InfoCommentService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class InfoCommentServiceBack implements InfoCommentService {

	@Override
	public InfoCommentEntity queryObject(Long infoCommentId){
		return null;
	}
	
	@Override
	public List<InfoCommentEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(InfoCommentEntity infoComment){

	}

	@Override
	public void commentPraise(InfoCommentEntity infoComment) {

	}

	@Override
	public void comment(InfoCommentEntity infoComment) {

	}

	@Override
	public void update(InfoCommentEntity infoComment){

	}
	
	@Override
	public void delete(Long infoCommentId){

	}
	
	@Override
	public void deleteBatch(Long[] infoCommentIds){

	}

	public List<CommentDTO> queryCommentList(Map<String, Object> map) {
		return null;
	}

}
