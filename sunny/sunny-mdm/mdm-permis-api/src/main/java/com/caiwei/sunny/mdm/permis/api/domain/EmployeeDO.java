package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class EmployeeDO {
    /**
    t_mdm_org_employee*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
    t_mdm_org_employee*emp_code
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String empCode;

    /**
    t_mdm_org_employee*emp_name
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String empName;

    /**
    t_mdm_org_employee*dept_code
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String deptCode;

    /**
    t_mdm_org_employee*dept_name
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String deptName;

    /**
    t_mdm_org_employee*gender
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer gender;

    /**
    t_mdm_org_employee*mobile_no
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String mobileNo;

    /**
    t_mdm_org_employee*email
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String email;

    /**
    t_mdm_org_employee*tel_phone
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String telPhone;

    /**
    t_mdm_org_employee*status
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_org_employee*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_org_employee.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.emp_code
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param empCode the value for t_mdm_org_employee.emp_code
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param empName the value for t_mdm_org_employee.emp_name
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param deptCode the value for t_mdm_org_employee.dept_code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param deptName the value for t_mdm_org_employee.dept_name
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param gender the value for t_mdm_org_employee.gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.mobile_no
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param mobileNo the value for t_mdm_org_employee.mobile_no
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param email the value for t_mdm_org_employee.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.tel_phone
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param telPhone the value for t_mdm_org_employee.tel_phone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_org_employee.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_employee.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_org_employee.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}