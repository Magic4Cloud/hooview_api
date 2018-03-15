package com.hooview.api.service;

import com.hooview.api.entity.OpenApplyEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 开户申请表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
 @RestController
public interface OpenApplyService {

	@RequestMapping(value="/openApply/queryObject",method = RequestMethod.GET)
	OpenApplyEntity queryObject(Long openApplyId);

	@RequestMapping(value="/openApply/queryList",method = RequestMethod.GET)
	List<OpenApplyEntity> queryList(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/openApply/queryTotal",method = RequestMethod.GET)
	int queryTotal(@RequestParam Map<String, Object> map);

	@RequestMapping(value="/openApply/save",method = RequestMethod.POST)
	void save(OpenApplyEntity openApply);

	@RequestMapping(value="/openApply/update",method = RequestMethod.POST)
	void update(@RequestBody OpenApplyEntity openApply);

	@RequestMapping(value="/openApply/delete",method = RequestMethod.POST)
	void delete(Long openApplyId);

	@RequestMapping(value="/openApply/deleteBatch",method = RequestMethod.POST)
	void deleteBatch(Long[] openApplyIds);

	@RequestMapping(value="/openApply/queryByMobile")
	OpenApplyEntity queryByMobile(String mobile);
}
