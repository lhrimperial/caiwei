package com.caiwei.business.user.api.domain;

import java.util.Date;

public class DepartmentPO {
    /**
     t_base_department*id
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private Integer id;

    /**
     * 部门编码
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String deptCode;

    /**
     * 部门名称
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String deptName;

    /**
     * 父级部门编码
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String parentCode;

    /**
     * 父级部门名称
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String parentName;

    /**
     t_base_department*version_no
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private Long versionNo;

    /**
     t_base_department*is_delete
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private Integer isDelete;

    /**
     t_base_department*create_user
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String createUser;

    /**
     t_base_department*create_time
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private Date createTime;

    /**
     t_base_department*modify_user
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private String modifyUser;

    /**
     t_base_department*modify_time
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param id the value for t_base_department.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param deptCode the value for t_base_department.dept_code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param deptName the value for t_base_department.dept_name
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.parent_code
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param parentCode the value for t_base_department.parent_code
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.parent_name
     */
    public String getParentName() {
        return parentName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param parentName the value for t_base_department.parent_name
     */
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param versionNo the value for t_base_department.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param isDelete the value for t_base_department.is_delete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param createUser the value for t_base_department.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param createTime the value for t_base_department.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param modifyUser the value for t_base_department.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @return the value of t_base_department.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:47:04
     * @param modifyTime the value for t_base_department.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}