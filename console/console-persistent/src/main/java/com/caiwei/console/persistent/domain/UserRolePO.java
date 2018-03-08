package com.caiwei.console.persistent.domain;


import com.github.framework.server.shared.domain.po.BasePO;

public class UserRolePO extends BasePO {

    private static final long serialVersionUID = 7876235266110596592L;
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