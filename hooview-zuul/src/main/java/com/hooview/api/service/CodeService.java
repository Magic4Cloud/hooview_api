package com.hooview.api.service;

import com.hooview.api.entity.CodeEntity;
import com.hooview.api.service.impl.CodeServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = CodeServiceBack.class)
public interface CodeService {

	@RequestMapping(value="/code/queryObject",method = RequestMethod.GET)
	CodeEntity queryObject(Long id);

	@RequestMapping(value="/code/queryList",method = RequestMethod.GET)
	List<CodeEntity> queryList(Map<String, Object> map);

	@RequestMapping(value="/code/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value="/code/save",method = RequestMethod.POST)
	void save(@RequestBody CodeEntity code);

	@RequestMapping(value="/code/update",method = RequestMethod.POST)
	void update(CodeEntity code);

	@RequestMapping(value="/code/delete",method = RequestMethod.POST)
	void delete(Long id);

	@RequestMapping(value="/code/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] ids);

	@RequestMapping(value="/code/checkcode",method = RequestMethod.GET)
	CodeEntity checkcode(@RequestParam Map<String, Object> map);
}
