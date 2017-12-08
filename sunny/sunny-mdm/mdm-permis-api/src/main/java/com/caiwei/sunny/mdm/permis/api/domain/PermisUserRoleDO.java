package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class PermisUserRoleDO {
    /**
    t_mdm_permis_user_role*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 用户编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer tuserId;

    /**
     * 组织编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer tdeptId;

    /**
     * 角色编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer troleId;

    /**
     * 逻辑删除
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_permis_user_role*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_permis_user_role.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.tuser_id
     */
    public Integer getTuserId() {
        return tuserId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param tuserId the value for t_mdm_permis_user_role.tuser_id
     */
    public void setTuserId(Integer tuserId) {
        this.tuserId = tuserId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.tdept_id
     */
    public Integer getTdeptId() {
        return tdeptId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param tdeptId the value for t_mdm_permis_user_role.tdept_id
     */
    public void setTdeptId(Integer tdeptId) {
        this.tdeptId = tdeptId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.trole_id
     */
    public Integer getTroleId() {
        return troleId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param troleId the value for t_mdm_permis_user_role.trole_id
     */
    public void setTroleId(Integer troleId) {
        this.troleId = troleId;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_permis_user_role.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_user_role.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_permis_user_role.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}