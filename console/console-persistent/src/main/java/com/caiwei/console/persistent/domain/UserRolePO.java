package com.caiwei.console.persistent.domain;


import com.github.framework.server.shared.domain.po.BasePO;

public class UserRolePO extends BasePO {

    private static final long serialVersionUID = 7876235266110596592L;
    /**
     * 用户编码
     */
    private Integer tuserId;

    /**
     * 组织编码
     */
    private Integer tdeptId;

    /**
     * 角色编码
     */
    private Integer troleId;

    public Integer getTuserId() {
        return tuserId;
    }

    public void setTuserId(Integer tuserId) {
        this.tuserId = tuserId;
    }

    public Integer getTdeptId() {
        return tdeptId;
    }

    public void setTdeptId(Integer tdeptId) {
        this.tdeptId = tdeptId;
    }

    public Integer getTroleId() {
        return troleId;
    }

    public void setTroleId(Integer troleId) {
        this.troleId = troleId;
    }
}