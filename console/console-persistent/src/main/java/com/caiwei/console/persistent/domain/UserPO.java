package com.caiwei.console.persistent.domain;

import com.github.framework.server.shared.domain.po.BasePO;

import java.util.Date;

public class UserPO extends BasePO {
    private static final long serialVersionUID = -78438906311456229L;

    /**
     * 登录用户名
     */
    private String userCode;

    /**
     * 登录密码
     */
    private String passWord;

    /**
     * 员工工号
     */
    private String empCode;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 组织编码
     */
    private String deptCode;

    /**
     * 上次登录时间
     */
    private Date lastLogin;

    /**
     * 备注
     */
    private String notes;

    public UserPO(){}

    public UserPO(String userCode, byte status) {
        this.userCode = userCode;
        this.status = status;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}