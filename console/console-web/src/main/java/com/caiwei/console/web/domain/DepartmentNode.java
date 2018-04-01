package com.caiwei.console.web.domain;

import com.github.framework.server.shared.entity.BaseEntity;

import java.util.Date;

/**
 *
 **/
public class DepartmentNode extends BaseEntity {
    private static final long serialVersionUID = -7479664859880628331L;

    private Integer tid;
    protected Byte status;
    private String createUser;
    private String modifyUser;
    private Date createTime;
    private Date modifyTime;
    private String active;

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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String getModifyUser() {
        return modifyUser;
    }

    @Override
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getCurrUserCode() {
        return currUserCode;
    }

    public void setCurrUserCode(String currUserCode) {
        this.currUserCode = currUserCode;
    }
}
