package com.caiwei.business.user.api.domain;

import java.util.Date;

public class RolePO {
    /**
     t_super_role*id
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private Integer id;

    /**
     * 角色CODE
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String roleCode;

    /**
     * 角色名称
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String roleName;

    /**
     * 系统编码
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String systemCode;

    /**
     * 角色类型
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String type;

    /**
     t_super_role*notes
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String notes;

    /**
     * 数据版本
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private Long versionNo;

    /**
     * 逻辑删除（1：是 0：否）
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private Integer isDeleted;

    /**
     t_super_role*create_user
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String createUser;

    /**
     t_super_role*create_time
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private Date createTime;

    /**
     t_super_role*modify_user
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private String modifyUser;

    /**
     t_super_role*modify_time
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param id the value for t_super_role.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param roleCode the value for t_super_role.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param roleName the value for t_super_role.role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.system_code
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param systemCode the value for t_super_role.system_code
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param type the value for t_super_role.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param notes the value for t_super_role.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param versionNo the value for t_super_role.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param isDeleted the value for t_super_role.is_deleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param createUser the value for t_super_role.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param createTime the value for t_super_role.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param modifyUser the value for t_super_role.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @return the value of t_super_role.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-09 15:09:13
     * @param modifyTime the value for t_super_role.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}