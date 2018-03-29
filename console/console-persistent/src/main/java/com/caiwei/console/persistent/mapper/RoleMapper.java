package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.common.domain.UserRoleDO;
import com.caiwei.console.persistent.domain.RolePO;
import com.caiwei.console.persistent.domain.RoleResourcePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int deleteRoleResource(@Param("roleCode") String roleCode, @Param("resCodes") List<String> resCodes);

    int batchSave(List<RoleResourcePO> roleResourcePOS);

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