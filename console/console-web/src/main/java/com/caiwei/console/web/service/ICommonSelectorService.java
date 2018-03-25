package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.EmployeeVO;
import com.caiwei.console.web.domain.UserVO;

/**
 *
 **/
public interface ICommonSelectorService {

    UserVO queryCommonUser(UserVO userVO);

    EmployeeVO searchEmployeeByParam(EmployeeVO employeeVO);
}
