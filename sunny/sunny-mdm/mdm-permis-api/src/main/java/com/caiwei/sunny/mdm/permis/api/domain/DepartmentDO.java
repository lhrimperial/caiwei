package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class DepartmentDO {
    /**
    t_mdm_org_department*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 部门编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String deptCode;

    /**
     * 部门名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String deptName;

    /**
     * 父级部门编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String parentCode;

    /**
     * 父级部门名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String parentName;

    /**
    t_mdm_org_department*status
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_org_department*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_org_department.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param deptCode the value for t_mdm_org_department.dept_code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param deptName the value for t_mdm_org_department.dept_name
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.parent_code
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param parentCode the value for t_mdm_org_department.parent_code
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.parent_name
     */
    public String getParentName() {
        return parentName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param parentName the value for t_mdm_org_department.parent_name
     */
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_org_department.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_org_department.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_org_department.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}