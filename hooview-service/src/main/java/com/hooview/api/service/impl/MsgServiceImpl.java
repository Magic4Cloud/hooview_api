package com.hooview.api.service.impl;

import com.hooview.api.dao.MsgDao;
import com.hooview.api.dto.MsgDTO;
import com.hooview.api.entity.MsgEntity;
import com.hooview.api.service.MsgService;
import com.hooview.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("msgService")
public class MsgServiceImpl implements MsgService {
	@Autowired
	private MsgDao msgDao;
	
	@Override
	public MsgEntity queryObject(Long msgId){
		return msgDao.queryObject(msgId);
	}
	
	@Override
	public List<MsgEntity> queryList(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
		return msgDao.queryList(query);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return msgDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody MsgEntity msg){
		msgDao.save(msg);
	}
	
	@Override
	public void update(MsgEntity msg){
		msgDao.update(msg);
	}
	
	@Override
	public void delete(Long msgId){
		msgDao.delete(msgId);
	}
	
	@Override
	public void deleteBatch(Long[] msgIds){
		msgDao.deleteBatch(msgIds);
	}

	public List<MsgDTO> queryMyList(@RequestParam Map<String, Object> map) {
		Query query = new Query(map);
		return msgDao.queryMyList(query);
	}

	public int queryMyTotal(@RequestParam Map<String, Object> map) {
		return msgDao.queryMyTotal(map);
	}

	public int deleteMyBatch(@RequestBody MsgEntity msgEntity) {
		return msgDao.deleteMyBatch(msgEntity);
	}

}
