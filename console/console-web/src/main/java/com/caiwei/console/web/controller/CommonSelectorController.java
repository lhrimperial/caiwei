package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.DepartmentVO;
import com.caiwei.console.web.domain.DistrictVO;
import com.caiwei.console.web.domain.EmployeeVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ICommonSelectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
@RequestMapping("/common")
public class CommonSelectorController {

    @Autowired
    private ICommonSelectorService commonSelectorService;

    @RequestMapping("/searchUserByParam")
    public UserVO searchUserByParam(UserVO userVO) {
        UserVO userVO1 = commonSelectorService.queryCommonUser(userVO);
        return userVO1;
    }

    @RequestMapping("/searchEmployeeByParam")
    public EmployeeVO searchEmployeeByParam(EmployeeVO employeeVO) {
        return commonSelectorService.searchEmployeeByParam(employeeVO);
    }


    @RequestMapping("/searchDepartmentByParam")
    public DepartmentVO searchDepartmentByParam(DepartmentVO departmentVO) {
        return null;
    }


    @RequestMapping("/queryDistrictByName")
    public DistrictVO queryDistrictByName(DistrictVO districtVO) {
        return null;
    }

    @RequestMapping("/queryAllNation")
    public DistrictVO queryAllNation(DistrictVO districtVO) {
        return null;
    }

    @RequestMapping("/queryProvince")
    public DistrictVO queryProvince(DistrictVO districtVO) {
        return null;
    }

    @RequestMapping("/queryCity")
    public DistrictVO queryCity(DistrictVO districtVO) {
        return null;
    }

    @RequestMapping("/queryArea")
    public DistrictVO queryArea(DistrictVO districtVO) {
        return null;
    }


}
