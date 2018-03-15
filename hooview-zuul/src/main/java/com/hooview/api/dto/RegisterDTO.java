package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月22日 13时59分
 * @discription
 */
//注册通用dto
public class RegisterDTO {

    private  String phone;//手机号
    private  String password;//密码
    private  String pwkey;//key
    private  String code;//验证码
    private  Integer type;//类型（1-登录注册，2-找回密码）

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwkey() {
        return pwkey;
    }

    public void setPwkey(String pwkey) {
        this.pwkey = pwkey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
