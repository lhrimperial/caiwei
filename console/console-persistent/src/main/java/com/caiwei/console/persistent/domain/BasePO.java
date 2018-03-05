package com.caiwei.console.persistent.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class BasePO implements Serializable {
    private static final long serialVersionUID = 2507518245696296782L;

    private Integer id;
    private Byte status;
    private Date createTime;
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
