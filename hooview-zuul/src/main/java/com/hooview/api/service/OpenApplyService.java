package com.hooview.api.service;

import com.hooview.api.entity.OpenApplyEntity;
import com.hooview.api.service.impl.OpenApplyServiceBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 开户申请表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:52:55
 */
@FeignClient(value = "hooview-service",fallback = OpenApplyServiceBack.class)
public interface OpenApplyService {

	@RequestMapping(value="/openApply/queryObject",method = RequestMethod.GET)
	OpenApplyEntity queryObject(Long openApplyId);

	@RequestMapping(value="/openApply/queryList",method = RequestMethod.GET)
	List<OpenApplyEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/openApply/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/openApply/save",method = RequestMethod.POST)
	void save(@RequestBody OpenApplyEntity openApply);

	@RequestMapping(value="/openApply/update",method = RequestMethod.POST)
	void update(@RequestBody OpenApplyEntity openApply);

	@RequestMapping(value="/openApply/delete",method = RequestMethod.POST)
	void delete(Long openApplyId);

	@RequestMapping(value="/openApply/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] openApplyIds);

	@RequestMapping(value="/openApply/queryByMobile",method = RequestMethod.GET)
	OpenApplyEntity queryByMobile(@RequestParam("mobile") String mobile);
}
