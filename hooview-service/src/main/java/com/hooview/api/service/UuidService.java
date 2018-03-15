package com.hooview.api.service;

import com.hooview.api.entity.CodeEntity;
import com.hooview.api.entity.UuidEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface UuidService {

	@RequestMapping(value="/uuid/queryObject",method = RequestMethod.GET)
	UuidEntity queryObject(String uuid);

	@RequestMapping(value="/uuid/save",method = RequestMethod.POST)
	void save(UuidEntity uuid);


	@RequestMapping(value="/uud/delete",method = RequestMethod.POST)
	void delete(String uuid);
}
