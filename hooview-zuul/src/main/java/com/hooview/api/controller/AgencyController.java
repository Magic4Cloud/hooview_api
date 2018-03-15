package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import com.hooview.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hooview.api.entity.AgencyEntity;
import com.hooview.api.service.AgencyService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 机构信息表
 *
 * @author lee
 * @email
 * @date 2018-02-07 17:18:52
 */
@RestController
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/admin/agency/list")
    @RequiresPermissions("api:agency:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<AgencyEntity> agencyList = agencyService.queryList(query);
        int total = agencyService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(agencyList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/admin/agency/info")
    @RequiresPermissions("api:agency:info")
    public R adminInfo(@RequestParam("agencyId") Long agencyId){
        AgencyEntity agency = agencyService.queryObject(agencyId);

        return R.ok().put("agency", agency);
    }

    /**
     * api
     */
    @RequestMapping("/api/agency/info")
    public R info(@RequestParam("userId") Long userId){
        Long agencyId = sysUserService.queryAgencyId(userId);
        AgencyEntity agency = null;
        if(agencyId != null){
            agency = agencyService.queryObject(agencyId);
        }
        return R.ok().put("agency", agency);
    }

    /**
     * 保存
     */
    @RequestMapping("/admin/agency/save")
    @RequiresPermissions("api:agency:save")
    public R save(@RequestBody AgencyEntity agency){
        agencyService.save(agency);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/admin/agency/update")
    @RequiresPermissions("api:agency:update")
    public R update(@RequestBody AgencyEntity agency){
        agencyService.update(agency);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/admin/agency/delete")
    @RequiresPermissions("api:agency:delete")
    public R delete(@RequestBody Map<String,Object> map){
        agencyService.delete(map);

        return R.ok();
    }

}
