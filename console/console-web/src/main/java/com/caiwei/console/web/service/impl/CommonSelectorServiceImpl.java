package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IEmployeeService;
import com.caiwei.console.business.service.impl.PermisUserService;
import com.caiwei.console.web.domain.EmployeeVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ICommonSelectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 **/
@Service
public class CommonSelectorServiceImpl implements ICommonSelectorService {

    @Autowired
    private PermisUserService permisUserService;

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public UserVO queryCommonUser(UserVO userVO) {
        userVO.setUserDOS(permisUserService.findUsers(userVO.getUserDO()));
        return userVO;
    }

    @Override
    public EmployeeVO searchEmployeeByParam(EmployeeVO employeeVO) {
        employeeVO.setEmployeeDOS(employeeService.findEmpByParam(employeeVO.getEmployeeDO()));
        return employeeVO;
    }
}
