package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月26日 18时10分
 * @discription
 */
@SuppressWarnings({"unchecked", "unused"})
public class SelectRoleDTO {
    private Long roleId;
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
