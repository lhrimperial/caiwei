package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.common.domain.PermisUserDO;

import java.io.Serializable;

/**
 *
 */
public class LoginInfoVO implements Serializable {

    private PermisUserDO currentUser;

    private Long currentServerTime;

    private DepartmentDO currentDept;


}
