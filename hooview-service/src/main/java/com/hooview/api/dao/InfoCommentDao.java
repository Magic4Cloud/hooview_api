package com.hooview.api.dao;

import com.hooview.api.dto.CommentDTO;
import com.hooview.api.entity.InfoCommentEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 资讯评论表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface InfoCommentDao extends BaseDao<InfoCommentEntity> {

    void commentPraise(InfoCommentEntity infoComment);

    void comment(InfoCommentEntity infoComment);

    List<CommentDTO> queryCommentList(Map<String, Object> map);
}
