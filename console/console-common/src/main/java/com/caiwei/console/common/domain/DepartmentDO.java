package com.caiwei.console.common.domain;

import com.github.framework.server.shared.domain.BaseDO;

/**
 * 部门业务实体
 */
public class DepartmentDO extends BaseDO {
    private static final long serialVersionUID = 330940443707871883L;
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

    private String currUserCode;

    public String getCurrUserCode() {
        return currUserCode;
    }

    public void setCurrUserCode(String currUserCode) {
        this.currUserCode = currUserCode;
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
