package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IDepartmentService;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.persistent.domain.DepartmentPO;
import com.caiwei.console.persistent.mapper.DepartmentMapper;
import com.github.framework.server.shared.define.Constants;
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
    public int insert(DepartmentPO departmentDO) {
        return departmentMapper.insert(departmentDO);
    }

    @Override
    public int update(DepartmentPO departmentDO) {
        return departmentMapper.update(departmentDO);
    }

    @Override
    public int delete(String deptCode) {
        DepartmentPO departmentPO = new DepartmentPO(deptCode, Constants.PoStatus.INACTIVE.value());
        return departmentMapper.update(departmentPO);
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

    @Override
    public List<DepartmentDO> findByParams(DepartmentDO departmentDO) {
        return departmentMapper.findByParams(departmentDO);
    }

    @Override
    public Long totalCount(DepartmentDO departmentDO) {
        return departmentMapper.totalCount(departmentDO);
    }

    @Override
    public List<DepartmentDO> findCurrUserByParams(DepartmentDO departmentDO) {
        return departmentMapper.findByParams(departmentDO);
    }

    @Override
    public Long currUserTotalCount(DepartmentDO departmentDO) {
        return departmentMapper.currUserTotalCount(departmentDO);
    }
}
