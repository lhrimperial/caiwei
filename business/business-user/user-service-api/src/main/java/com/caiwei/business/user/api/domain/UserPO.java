package com.caiwei.business.user.api.domain;

import java.util.Date;

public class UserPO {
    /**
     t_super_user*id
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Integer id;

    /**
     * 登录用户名
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String userCode;

    /**
     * 登录密码
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String passWord;

    /**
     * 员工工号
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String empCode;

    /**
     * 员工姓名
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String empName;

    /**
     * 组织编码
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String orgCode;

    /**
     * 是否是本公司员工(1：是 0：否)
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Integer isEmp;

    /**
     * 上次登录时间
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Date lastLogin;

    /**
     * 备注
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String notes;

    /**
     * 数据版本
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Long versionNo;

    /**
     * 逻辑删除（1：是 0：否）
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Integer isDeleted;

    /**
     t_super_user*create_user
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String createUser;

    /**
     t_super_user*create_time
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Date createTime;

    /**
     t_super_user*modify_user
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private String modifyUser;

    /**
     t_super_user*modify_time
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param id the value for t_super_user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.user_code
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param userCode the value for t_super_user.user_code
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.pass_word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param passWord the value for t_super_user.pass_word
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.emp_code
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param empCode the value for t_super_user.emp_code
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param empName the value for t_super_user.emp_name
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param orgCode the value for t_super_user.org_code
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.is_emp
     */
    public Integer getIsEmp() {
        return isEmp;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param isEmp the value for t_super_user.is_emp
     */
    public void setIsEmp(Integer isEmp) {
        this.isEmp = isEmp;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.last_login
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param lastLogin the value for t_super_user.last_login
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param notes the value for t_super_user.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param versionNo the value for t_super_user.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param isDeleted the value for t_super_user.is_deleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param createUser the value for t_super_user.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param createTime the value for t_super_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param modifyUser the value for t_super_user.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @return the value of t_super_user.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:08:41
     * @param modifyTime the value for t_super_user.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}