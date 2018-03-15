package com.hooview.api.entity;

import java.io.Serializable;


/**
 * 禁言列表
 *
 * @author lee
 * @email
 * @date 2018-03-05 09:12:07
 */
public class MuteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //聊天室id
    private String chatroomId;
    //
    private String userName;

    /**
     * 设置：id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：id
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：聊天室id
     */
    public void setChatroomId(String chatroomId) {
        this.chatroomId = chatroomId;
    }
    /**
     * 获取：聊天室id
     */
    public String getChatroomId() {
        return chatroomId;
    }
    /**
     * 设置：
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 获取：
     */
    public String getUserName() {
        return userName;
    }
}
