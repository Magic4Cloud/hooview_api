package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 主播所属直播类型表
 *
 * @author lee
 * @email
 * @date 2018-02-09 16:48:41
 */
public class LiveTypeUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //主播ID
    private Long userid;
    //直播类型id
    private Integer liveTypeId;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：主播ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    /**
     * 获取：主播ID
     */
    public Long getUserid() {
        return userid;
    }
    /**
     * 设置：直播类型id
     */
    public void setLiveTypeId(Integer liveTypeId) {
        this.liveTypeId = liveTypeId;
    }
    /**
     * 获取：直播类型id
     */
    public Integer getLiveTypeId() {
        return liveTypeId;
    }
}
