package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.common.domain.UserRoleDO;
import com.caiwei.console.persistent.domain.RolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int insert(RolePO record);

    int update(RolePO record);

    void updateStatus(@Param("roleCodes") List<String> roleCodes, @Param("status") Byte status);

    RoleDO findById(Integer id);

    RoleDO findByCode(String roleCode);

    List<RoleDO> findByParam(RoleDO roleDO);

    long totalCount(RoleDO roleDO);

    List<RoleDO> queryOrgRoleByUserCode(@Param("userCode") String userCode, @Param("deptCode") String deptCode);

    int deleteUserRole(@Param("userCode") String userCode, @Param("deptCode") String deptCode);

    int batchSaveUserRole(List<UserRoleDO> userRoleDOS);
}