package com.caiwei.console.business.service;

import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.common.domain.UserRoleDO;
import com.caiwei.console.persistent.domain.RoleResourcePO;

import java.util.List;

/**
 *
 **/
public interface IRoleService {

    int batchSave(List<RoleResourcePO> roleResourcePOS);

    int deleteRoleResource(String roleCode, List<String> resCodes);

    void save(RoleDO roleDO);

    void update(RoleDO roleDO);

    void updateStatus(List<String> roleCodes, Byte status);

    void delete(String roleCode);

    RoleDO findById(Integer id);

    RoleDO findByCode(String roleCode);

    List<RoleDO> findByParam(RoleDO roleDO, int pageNo, int pageSize);

    long totalCount(RoleDO roleDO);

    List<RoleDO> queryOrgRoleByUserCode(String userCode, String deptCode);

    int deleteUserRole(String userCode, String deptCode);

    int batchSaveUserRole(List<UserRoleDO> userRoleDOS);
}
