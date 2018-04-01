package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IDepartmentService;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.persistent.domain.DepartmentPO;
import com.caiwei.console.persistent.mapper.DepartmentMapper;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.framework.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        if (departmentDO == null) {
            throw new BusinessException("param is null");
        }
        DepartmentPO departmentPO = new DepartmentPO();
        BeanCopyUtils.copyBean(departmentDO, departmentPO);
        departmentPO.setCreateTime(new Date());
        departmentPO.setModifyTime(new Date());
        departmentPO.setStatus(Constants.PO_ACTIVE);
        return departmentMapper.insert(departmentPO);
    }

    @Override
    public int update(DepartmentDO departmentDO) {
        if (departmentDO == null) {
            throw new BusinessException("param is null");
        }
        DepartmentPO departmentPO = new DepartmentPO();
        BeanCopyUtils.copyBean(departmentDO, departmentPO);
        departmentPO.setModifyTime(new Date());
        return departmentMapper.update(departmentPO);
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
        if (StringUtils.isNotBlank(departmentDO.getActive())) {
            departmentDO.setStatus(ConvertUtil.activeToStatus(departmentDO.getActive()));
        }
        return departmentMapper.findByParams(departmentDO);
    }

    @Override
    public Long totalCount(DepartmentDO departmentDO) {
        if (StringUtils.isNotBlank(departmentDO.getActive())) {
            departmentDO.setStatus(ConvertUtil.activeToStatus(departmentDO.getActive()));
        }
        return departmentMapper.totalCount(departmentDO);
    }

}
