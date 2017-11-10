package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class PermisRoleDO {
    /**
    t_mdm_permis_role*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 角色CODE
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String roleCode;

    /**
     * 角色名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String roleName;

    /**
     * 系统编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String systemCode;

    /**
     * 角色类型
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String type;

    /**
    t_mdm_permis_role*notes
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
    t_mdm_permis_role*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_permis_role.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param roleCode the value for t_mdm_permis_role.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param roleName the value for t_mdm_permis_role.role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.system_code
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param systemCode the value for t_mdm_permis_role.system_code
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param type the value for t_mdm_permis_role.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param notes the value for t_mdm_permis_role.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_permis_role.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_permis_role.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}