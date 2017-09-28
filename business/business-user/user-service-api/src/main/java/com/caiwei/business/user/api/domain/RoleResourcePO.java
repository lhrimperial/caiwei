package com.caiwei.business.user.api.domain;

import java.util.Date;

public class RoleResourcePO {
    /**
     t_super_role_resource*id
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private Integer id;

    /**
     t_super_role_resource*role_code
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private String roleCode;

    /**
     t_super_role_resource*res_code
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private String resCode;

    /**
     t_super_role_resource*version_no
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private Long versionNo;

    /**
     t_super_role_resource*is_deleted
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private Integer isDeleted;

    /**
     t_super_role_resource*create_user
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private String createUser;

    /**
     t_super_role_resource*create_time
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private Date createTime;

    /**
     t_super_role_resource*modify_user
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private String modifyUser;

    /**
     t_super_role_resource*modify_time
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param id the value for t_super_role_resource.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param roleCode the value for t_super_role_resource.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.res_code
     */
    public String getResCode() {
        return resCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param resCode the value for t_super_role_resource.res_code
     */
    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param versionNo the value for t_super_role_resource.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param isDeleted the value for t_super_role_resource.is_deleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param createUser the value for t_super_role_resource.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param createTime the value for t_super_role_resource.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param modifyUser the value for t_super_role_resource.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @return the value of t_super_role_resource.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:25
     * @param modifyTime the value for t_super_role_resource.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}