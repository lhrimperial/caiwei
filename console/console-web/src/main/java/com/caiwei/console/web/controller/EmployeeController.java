package com.caiwei.console.web.controller;

import com.caiwei.console.business.service.IEmployeeService;
import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.web.domain.EmployeeVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends AbstractController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    public String index() {
        return "/dataset/employee";
    }

    @ResponseBody
    @RequestMapping("/queryEmpList")
    public EmployeeVO queryEmpList(@ModelAttribute EmployeeVO employeeVO) {
        if (employeeVO == null) {
            return null;
        }
        employeeVO.setEmployeeDOS(employeeService.findEmpByPage(employeeVO.getEmployeeDO(), employeeVO.getPage(), employeeVO.getLimit()));
        employeeVO.setTotalCount(employeeService.totalCount(employeeVO.getEmployeeDO()));
        return employeeVO;
    }
}
