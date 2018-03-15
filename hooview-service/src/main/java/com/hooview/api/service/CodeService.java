package com.hooview.api.service;

import com.hooview.api.entity.CodeEntity;
import org.springframework.web.bind.annotation.*;

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
public interface CodeService {

	@RequestMapping(value="/code/queryObject",method = RequestMethod.GET)
	CodeEntity queryObject(Long id);

	@RequestMapping(value="/code/queryList",method = RequestMethod.GET)
	List<CodeEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/code/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/code/save",method = RequestMethod.POST)
	void save(CodeEntity code);

	@RequestMapping(value="/code/update",method = RequestMethod.POST)
	void update(CodeEntity code);

	@RequestMapping(value="/code/delete",method = RequestMethod.POST)
	void delete(Long id);

	@RequestMapping(value="/code/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] ids);

	//查询验证码是否过期
	@RequestMapping(value="/code/checkcode")
	CodeEntity checkcode(Map<String, Object> map);
}
