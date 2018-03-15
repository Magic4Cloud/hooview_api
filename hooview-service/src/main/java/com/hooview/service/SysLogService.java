package com.hooview.service;

import com.hooview.entity.SysLogEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 系统日志表
 * 
 * @author liyu
 * @email 
 * @date 2018-01-17 16:12:06
 */
@RestController
public interface SysLogService {

	@RequestMapping(value ="/log/queryObject",method = RequestMethod.GET)
	SysLogEntity queryObject(Long id);

	@RequestMapping(value ="/log/queryList",method = RequestMethod.GET)
	List<SysLogEntity> queryList(Map<String, Object> map);

	@RequestMapping(value ="/log/queryTotal",method = RequestMethod.GET)
	int queryTotal(Map<String, Object> map);

	@RequestMapping(value ="/log/save",method = RequestMethod.POST)
	void save(SysLogEntity sysLog);

	@RequestMapping(value ="/log/update",method = RequestMethod.POST)
	void update(SysLogEntity sysLog);

	@RequestMapping(value ="/log/delete",method = RequestMethod.POST)
	void delete(Long id);

	@RequestMapping(value ="/log/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] ids);
}
