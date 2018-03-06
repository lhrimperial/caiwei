package com.caiwei.console.persistent.domain;


import com.github.framework.server.shared.domain.po.BasePO;

public class DepartmentPO extends BasePO {

    private static final long serialVersionUID = 2704083787263616186L;
    /**
     * 部门编码
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 父级部门编码
     */
    private String parentCode;

    /**
     * 父级部门名称
     */
    private String parentName;

    public DepartmentPO(){}

    public DepartmentPO(String deptCode, byte status) {
        this.deptCode = deptCode;
        this.status = status;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}