package com.caiwei.console.common.domain;

import com.github.framework.server.shared.domain.BaseDO;

/**
 *
 */
public class UserRoleDO extends BaseDO {
    private static final long serialVersionUID = 6870994930882584236L;
    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 组织编码
     */
    private String deptCode;

    /**
     * 角色编码
     */
    private String roleCode;

    public UserRoleDO() {
    }

    public UserRoleDO(String userCode, String deptCode, String roleCode) {
        this.userCode = userCode;
        this.deptCode = deptCode;
        this.roleCode = roleCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
