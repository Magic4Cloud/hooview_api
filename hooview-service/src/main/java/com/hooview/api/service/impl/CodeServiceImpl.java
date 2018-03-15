package com.hooview.api.service.impl;

import com.hooview.api.dao.CodeDao;
import com.hooview.api.entity.CodeEntity;
import com.hooview.api.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service("codeService")
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDao codeDao;
	
	@Override
	public CodeEntity queryObject(Long id){
		return codeDao.queryObject(id);
	}
	
	@Override
	public List<CodeEntity> queryList(Map<String, Object> map){
		return codeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return codeDao.queryTotal(map);
	}
	
	@Override
	public void save(@RequestBody CodeEntity code){
		codeDao.save(code);
	}
	
	@Override
	public void update(CodeEntity code){
		codeDao.update(code);
	}
	
	@Override
	public void delete(Long id){
		codeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		codeDao.deleteBatch(ids);
	}

	@Override
	public CodeEntity checkcode(@RequestParam Map<String, Object> map) {
		return codeDao.queryByCheckCode(map);
	}

}
