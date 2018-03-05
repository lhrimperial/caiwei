package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IEmployeeService;
import com.caiwei.console.persistent.domain.EmployeePO;
import com.caiwei.console.persistent.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int insert(EmployeePO employeeDO) {
        return employeeMapper.insert(employeeDO);
    }

    @Override
    public int update(EmployeePO employeeDO) {
        return employeeMapper.update(employeeDO);
    }

    @Override
    public int delete(int teId) {
        return employeeMapper.delete(teId);
    }

    @Override
    public EmployeePO findByEmpCode(String empCode) {
        return employeeMapper.findByEmpCode(empCode);
    }

    @Override
    public List<EmployeePO> findByDeptCode(String deptCode) {
        return employeeMapper.findByDeptCode(deptCode);
    }
}
