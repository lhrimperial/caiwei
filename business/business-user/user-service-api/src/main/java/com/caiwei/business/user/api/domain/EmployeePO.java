package com.caiwei.business.user.api.domain;

import java.util.Date;

public class EmployeePO {
    /**
     t_base_employee*id
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Integer id;

    /**
     t_base_employee*emp_code
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String empCode;

    /**
     t_base_employee*emp_name
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String empName;

    /**
     t_base_employee*dept_code
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String deptCode;

    /**
     t_base_employee*dept_name
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String deptName;

    /**
     t_base_employee*gender
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Integer gender;

    /**
     t_base_employee*mobile_no
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String mobileNo;

    /**
     t_base_employee*email
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String email;

    /**
     t_base_employee*tel_phone
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String telPhone;

    /**
     t_base_employee*version_no
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Long versionNo;

    /**
     t_base_employee*is_delete
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Integer isDelete;

    /**
     t_base_employee*create_user
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String createUser;

    /**
     t_base_employee*create_time
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Date createTime;

    /**
     t_base_employee*modify_user
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private String modifyUser;

    /**
     t_base_employee*modify_time
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param id the value for t_base_employee.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.emp_code
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param empCode the value for t_base_employee.emp_code
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param empName the value for t_base_employee.emp_name
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param deptCode the value for t_base_employee.dept_code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param deptName the value for t_base_employee.dept_name
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param gender the value for t_base_employee.gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.mobile_no
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param mobileNo the value for t_base_employee.mobile_no
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param email the value for t_base_employee.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.tel_phone
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param telPhone the value for t_base_employee.tel_phone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param versionNo the value for t_base_employee.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param isDelete the value for t_base_employee.is_delete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param createUser the value for t_base_employee.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param createTime the value for t_base_employee.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param modifyUser the value for t_base_employee.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @return the value of t_base_employee.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:25
     * @param modifyTime the value for t_base_employee.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}