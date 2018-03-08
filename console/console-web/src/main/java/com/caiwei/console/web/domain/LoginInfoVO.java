package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.common.domain.PermisUserDO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class LoginInfoVO implements Serializable {

    private static final long serialVersionUID = 7218549975580387433L;
    private PermisUserDO currentUser;

    private Date currentServerTime;

    private DepartmentDO currentDept;


    public PermisUserDO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(PermisUserDO currentUser) {
        this.currentUser = currentUser;
    }

    public Date getCurrentServerTime() {
        return currentServerTime;
    }

    public void setCurrentServerTime(Date currentServerTime) {
        this.currentServerTime = currentServerTime;
    }

    public DepartmentDO getCurrentDept() {
        return currentDept;
    }

    public void setCurrentDept(DepartmentDO currentDept) {
        this.currentDept = currentDept;
    }
}
