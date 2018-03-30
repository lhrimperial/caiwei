package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IEmployeeService;
import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.persistent.domain.EmployeePO;
import com.caiwei.console.persistent.mapper.EmployeeMapper;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        if (employeeDO == null) {
            throw new BusinessException("参数不能为空！");
        }
        EmployeePO employeePO = new EmployeePO();
        BeanCopyUtils.copyBean(employeeDO, employeePO);
        employeePO.setStatus(Constants.PO_ACTIVE);
        employeePO.setCreateTime(new Date());
        employeePO.setModifyTime(new Date());
        return employeeMapper.insert(employeePO);
    }

    @Override
    public int update(EmployeeDO employeeDO) {
        if (employeeDO == null) {
            throw new BusinessException("参数不能为空！");
        }
        EmployeePO employeePO = new EmployeePO();
        BeanCopyUtils.copyBean(employeeDO, employeePO);
        employeePO.setModifyTime(new Date());
        if (StringUtils.isNotBlank(employeeDO.getActive())) {
            employeePO.setStatus(ConvertUtil.activeToStatus(employeeDO.getActive()));
        }
        return employeeMapper.update(employeePO);
    }

    @Override
    public int delete(String empCode) {
        EmployeePO employeePO = new EmployeePO(empCode, Constants.PoStatus.INACTIVE.value());
        return employeeMapper.update(employeePO);
    }

    @Override
    public EmployeeDO findByEmpCode(String empCode) {
        return employeeMapper.findByEmpCode(empCode);
    }

    @Override
    public List<EmployeeDO> findByDeptCode(String deptCode) {
        return employeeMapper.findByDeptCode(deptCode);
    }

    @Override
    public List<EmployeeDO> findEmpByParam(EmployeeDO employeeDO) {
        if (employeeDO == null) {
            throw new BusinessException("param is empty!");
        }
        if (StringUtils.isNotBlank(employeeDO.getActive())) {
            employeeDO.setStatus(ConvertUtil.activeToStatus(employeeDO.getActive()));
        }
        return employeeMapper.findEmpByParam(employeeDO);
    }

    @Override
    public List<EmployeeDO> findEmpByPage(EmployeeDO employeeDO, int pageNo, int pageSize) {
        if (employeeDO == null) {
            throw new BusinessException("param is empty!");
        }
        if (StringUtils.isNotBlank(employeeDO.getActive())) {
            employeeDO.setStatus(ConvertUtil.activeToStatus(employeeDO.getActive()));
        }
        PageHelper.startPage(pageNo, pageSize);
        return employeeMapper.findEmpByParam(employeeDO);
    }

    @Override
    public long totalCount(EmployeeDO employeeDO) {
        if (employeeDO == null) {
            throw new BusinessException("param is empty!");
        }
        if (StringUtils.isNotBlank(employeeDO.getActive())) {
            employeeDO.setStatus(ConvertUtil.activeToStatus(employeeDO.getActive()));
        }

        return employeeMapper.totalCount(employeeDO);
    }
}
