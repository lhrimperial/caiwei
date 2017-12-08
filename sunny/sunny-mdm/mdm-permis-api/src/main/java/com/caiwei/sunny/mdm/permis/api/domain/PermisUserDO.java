package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class PermisUserDO {
    /**
    t_mdm_permis_user*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 登录用户名
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String userCode;

    /**
     * 登录密码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String passWord;

    /**
     * 员工工号
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String empCode;

    /**
     * 员工姓名
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String empName;

    /**
     * 组织编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String deptCode;

    /**
     * 上次登录时间
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date lastLogin;

    /**
     * 备注
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String notes;

    /**
     * 逻辑删除（1：是 0：否）
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_permis_user*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_permis_user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.user_code
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param userCode the value for t_mdm_permis_user.user_code
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.pass_word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param passWord the value for t_mdm_permis_user.pass_word
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.emp_code
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param empCode the value for t_mdm_permis_user.emp_code
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param empName the value for t_mdm_permis_user.emp_name
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param deptCode the value for t_mdm_permis_user.dept_code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.last_login
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param lastLogin the value for t_mdm_permis_user.last_login
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param notes the value for t_mdm_permis_user.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_permis_user.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_permis_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}