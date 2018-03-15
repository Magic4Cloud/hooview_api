package com.hooview.api.service.impl;

import com.hooview.api.entity.CodeEntity;
import com.hooview.api.service.CodeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class CodeServiceBack implements CodeService {

	@Override
	public CodeEntity queryObject(Long id){
		return null;
	}
	
	@Override
	public List<CodeEntity> queryList(Map<String, Object> map){
		return null;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}
	
	@Override
	public void save(CodeEntity code){

	}
	
	@Override
	public void update(CodeEntity code){

	}
	
	@Override
	public void delete(Long id){

	}
	
	@Override
	public void deleteBatch(Long[] ids){

	}

	@Override
	public CodeEntity checkcode(Map<String, Object> map) {
		return null;
	}

}
