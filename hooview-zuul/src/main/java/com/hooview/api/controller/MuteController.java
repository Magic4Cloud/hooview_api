package com.hooview.api.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hooview.api.entity.MuteEntity;
import com.hooview.api.service.MuteService;
import com.hooview.common.utils.PageUtils;
import com.hooview.common.utils.Query;
import com.hooview.common.utils.R;




/**
 * 禁言列表
 *
 * @author lee
 * @email
 * @date 2018-03-05 09:12:07
 */
@RestController
public class MuteController {
    @Autowired
    private MuteService muteService;

    /**
     * 列表
     */
//    @RequestMapping("/mute/list")
//    @RequiresPermissions("api:mute:list")
//    public R list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//
//        List<MuteEntity> muteList = muteService.queryList(query);
//        int total = muteService.queryTotal(query);
//
//        PageUtils pageUtil = new PageUtils(muteList, total, query.getLimit(), query.getPage());
//
//        return R.ok().put("page", pageUtil);
//    }


    /**
     * 信息
     */
    @RequestMapping("/mute/info/{id}")
    @RequiresPermissions("api:mute:info")
    public R info(@PathVariable("id") Long id){
        MuteEntity mute = muteService.queryObject(id);

        return R.ok().put("mute", mute);
    }

    /**
     * 保存
     */
    @RequestMapping("/mute/save")
    public R save(@RequestBody MuteEntity mute){
        muteService.save(mute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/mute/update")
    @RequiresPermissions("api:mute:update")
    public R update(@RequestBody MuteEntity mute){
        muteService.update(mute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "api/mute/delete",method = RequestMethod.POST)
    public R delete(@RequestBody Map<String, Object> map){
        muteService.delete(map);

        return R.ok();
    }

}
