package com.caiwei.console.web.service;

import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.web.domain.DepartmentVO;
import com.caiwei.console.web.domain.LoginInfoVO;

/**
 *
 */
public interface ILoginService {

    void logout();

    PermisUserDO userLogin(String userCode, String password);

    LoginInfoVO currentLoginUserInfo();

    DepartmentVO currentUserDepts(String deptName);

    void changeCurrentUserDept(String deptCode);

}
