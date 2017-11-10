package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class PermisRoleResourceDO {
    /**
    t_mdm_permis_role_resource*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 角色ID
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer troleId;

    /**
     * 权限ID
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer tresId;

    /**
    t_mdm_permis_role_resource*status
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_permis_role_resource*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role_resource.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_permis_role_resource.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role_resource.trole_id
     */
    public Integer getTroleId() {
        return troleId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param troleId the value for t_mdm_permis_role_resource.trole_id
     */
    public void setTroleId(Integer troleId) {
        this.troleId = troleId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role_resource.tres_id
     */
    public Integer getTresId() {
        return tresId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param tresId the value for t_mdm_permis_role_resource.tres_id
     */
    public void setTresId(Integer tresId) {
        this.tresId = tresId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role_resource.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_permis_role_resource.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_role_resource.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_permis_role_resource.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}