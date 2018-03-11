package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.EmployeeVO;
import com.caiwei.console.web.domain.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
public class CommonSelectorController {

    @RequestMapping("/searchUserByParam")
    public UserVO searchUserByParam(UserVO userVO) {

        return null;
    }

    @RequestMapping("/searchEmployeeByParam")
    public EmployeeVO searchEmployeeByParam(EmployeeVO employeeVO) {
        return null;
    }
}
