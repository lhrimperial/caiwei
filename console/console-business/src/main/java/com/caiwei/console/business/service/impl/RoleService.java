package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IRoleService;
import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.common.domain.UserRoleDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.persistent.domain.RolePO;
import com.caiwei.console.persistent.mapper.RoleMapper;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 *
 **/
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public void save(RoleDO roleDO) {
        RolePO rolePO = new RolePO();
        BeanCopyUtils.copyBean(roleDO,rolePO);
        if (rolePO.getCreateTime() == null) {
            rolePO.setCreateTime(new Date());
        }
        if (rolePO.getModifyTime() == null) {
            rolePO.setModifyTime(new Date());
        }
        if (rolePO.getStatus() == null) {
            rolePO.setStatus(Constants.PO_ACTIVE);
        }
        roleMapper.insert(rolePO);
    }

    @Override
    public void update(RoleDO roleDO) {
        RolePO rolePO = new RolePO();
        BeanCopyUtils.copyBean(roleDO, rolePO);
        if (rolePO.getModifyTime() == null) {
            rolePO.setModifyTime(new Date());
        }
        if (com.github.framework.util.string.StringUtils.isNotBlank(rolePO.getActive())) {
            rolePO.setStatus(ConvertUtil.activeToStatus(roleDO.getActive()));
        }
        roleMapper.update(rolePO);
    }

    @Override
    public void updateStatus(List<String> roleCodes, Byte status) {
        roleMapper.updateStatus(roleCodes, status);
    }

    @Override
    public void delete(String roleCode) {
        RolePO rolePO = new RolePO();
        rolePO.setStatus(Constants.PO_INACTIVE);
        rolePO.setRoleCode(roleCode);
        roleMapper.update(rolePO);
    }

    @Override
    public RoleDO findById(Integer id) {
        RoleDO roleDO = roleMapper.findById(id);
        if (roleDO != null) {
            roleDO.setActive(ConvertUtil.statusToActive(roleDO.getStatus()));
        }
        return roleDO;
    }

    @Override
    public RoleDO findByCode(String roleCode) {
        return roleMapper.findByCode(roleCode);
    }

    @Override
    public List<RoleDO> findByParam(RoleDO roleDO, int pageNo, int pageSize) {
        if (roleDO != null) {
            roleDO.setStatus(ConvertUtil.activeToStatus(roleDO.getActive()));
        }
        if (pageNo != 0 && pageSize != 0) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return roleMapper.findByParam(roleDO);
    }

    @Override
    public List<RoleDO> queryOrgRoleByUserCode(String userCode, String deptCode) {
        return roleMapper.queryOrgRoleByUserCode(userCode, deptCode);
    }

    @Override
    public int deleteUserRole(String userCode, String deptCode) {
        return roleMapper.deleteUserRole(userCode, deptCode);
    }

    @Override
    public int batchSaveUserRole(List<UserRoleDO> userRoleDOS) {
        return roleMapper.batchSaveUserRole(userRoleDOS);
    }
}
