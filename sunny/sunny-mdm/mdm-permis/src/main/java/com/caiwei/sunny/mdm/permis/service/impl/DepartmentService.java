package com.caiwei.sunny.mdm.permis.service.impl;

import com.caiwei.sunny.mdm.permis.api.domain.DepartmentDO;
import com.caiwei.sunny.mdm.permis.api.service.IDepartmentService;
import com.caiwei.sunny.mdm.permis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int insert(DepartmentDO departmentDO) {
        return departmentMapper.insert(departmentDO);
    }

    @Override
    public int update(DepartmentDO departmentDO) {
        return departmentMapper.update(departmentDO);
    }

    @Override
    public int delete(int tdId) {
        return departmentMapper.delete(tdId);
    }

    @Override
    public DepartmentDO findByDeptCode(String deptCode) {
        return departmentMapper.findByDeptCode(deptCode);
    }

    @Override
    public DepartmentDO findByEmpCode(String empCode) {
        return departmentMapper.findByEmpCode(empCode);
    }

    @Override
    public List<DepartmentDO> findByParentCode(String parentCode) {
        return departmentMapper.findByParentCode(parentCode);
    }
}
