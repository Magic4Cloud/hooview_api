package com.hooview.api.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 机构信息表
 *
 * @author lee
 * @email
 * @date 2018-02-07 17:18:52
 */
public class AgencyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

//    //机构信息表
//    private Long id;
    //机构id
    private Integer agencyId;
    //机构名称
    private String agencyName;
    //
    private String agencyIntroduction;

//    /**
//     * 设置：机构信息表
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
//    /**
//     * 获取：机构信息表
//     */
//    public Long getId() {
//        return id;
//    }
    /**
     * 设置：机构id
     */
    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }
    /**
     * 获取：机构id
     */
    public Integer getAgencyId() {
        return agencyId;
    }
    /**
     * 设置：机构名称
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    /**
     * 获取：机构名称
     */
    public String getAgencyName() {
        return agencyName;
    }
    /**
     * 设置：
     */
    public void setAgencyIntroduction(String agencyIntroduction) {
        this.agencyIntroduction = agencyIntroduction;
    }
    /**
     * 获取：
     */
    public String getAgencyIntroduction() {
        return agencyIntroduction;
    }
}
