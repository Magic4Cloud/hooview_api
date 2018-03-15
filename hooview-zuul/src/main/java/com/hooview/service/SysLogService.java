package com.hooview.service;

import com.hooview.entity.SysLogEntity;
import com.hooview.service.impl.SysLogServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * 
 * @author lee
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
@FeignClient(value = "hooview-service",fallback = SysLogServiceBack.class)
public interface SysLogService {

	@RequestMapping(value = "/log/queryObject",method = RequestMethod.GET)
	SysLogEntity queryObject(@RequestParam("id") Long id);

	@RequestMapping(value = "/log/queryList",method = RequestMethod.GET)
	List<SysLogEntity> queryList(@RequestParam("map") Map<String, Object> map);

	@RequestMapping(value = "/log/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam("map") Map<String, Object> map);

	@RequestMapping(value = "/log/save",method = RequestMethod.POST)
	void save(@RequestParam("sysLog") SysLogEntity sysLog);

	@RequestMapping(value = "/log/delete",method = RequestMethod.POST)
	void delete(@RequestParam("id")Long id);

	@RequestMapping(value = "/log/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(@RequestParam("ids") Long[] ids);
}
