package com.caiwei.sunny.mdm.permis.service.impl;

import com.caiwei.sunny.mdm.permis.api.domain.EmployeeDO;
import com.caiwei.sunny.mdm.permis.api.service.IEmployeeService;
import com.caiwei.sunny.mdm.permis.mapper.EmployeeMapper;
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
    public int insert(EmployeeDO employeeDO) {
        return employeeMapper.insert(employeeDO);
    }

    @Override
    public int update(EmployeeDO employeeDO) {
        return employeeMapper.update(employeeDO);
    }

    @Override
    public int delete(int teId) {
        return employeeMapper.delete(teId);
    }

    @Override
    public EmployeeDO findByEmpCode(String empCode) {
        return employeeMapper.findByEmpCode(empCode);
    }

    @Override
    public List<EmployeeDO> findByDeptCode(String deptCode) {
        return employeeMapper.findByDeptCode(deptCode);
    }
}
