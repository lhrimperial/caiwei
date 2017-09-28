package com.caiwei.business.user.api.domain;

import java.util.Date;

public class UserRolePO {
    /**
     t_super_user_role*id
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private Integer id;

    /**
     * 用户编码
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private String userCode;

    /**
     * 组织编码
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private String orgCode;

    /**
     * 角色编码
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private String roleCode;

    /**
     * 数据版本
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private Long versionNo;

    /**
     * 逻辑删除
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private Integer isDeleted;

    /**
     t_super_user_role*create_user
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private String createUser;

    /**
     t_super_user_role*create_time
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private Date createTime;

    /**
     t_super_user_role*modify_user
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private String modifyUser;

    /**
     t_super_user_role*modify_time
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param id the value for t_super_user_role.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.user_code
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param userCode the value for t_super_user_role.user_code
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param orgCode the value for t_super_user_role.org_code
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param roleCode the value for t_super_user_role.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param versionNo the value for t_super_user_role.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param isDeleted the value for t_super_user_role.is_deleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param createUser the value for t_super_user_role.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param createTime the value for t_super_user_role.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param modifyUser the value for t_super_user_role.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @return the value of t_super_user_role.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:10:01
     * @param modifyTime the value for t_super_user_role.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}