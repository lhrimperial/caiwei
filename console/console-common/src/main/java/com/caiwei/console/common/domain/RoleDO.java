package com.caiwei.console.common.domain;

import com.github.framework.server.shared.domain.BaseDO;

/**
 *
 **/
public class RoleDO extends BaseDO {
    private static final long serialVersionUID = -9066420389467185080L;

    /**
     * 角色CODE
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 系统编码
     */
    private String systemCode;

    /**
     * 角色类型
     */
    private String type;

    private String notes;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
