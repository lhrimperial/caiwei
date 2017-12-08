package com.caiwei.sunny.mdm.permis.mapper;

import com.caiwei.sunny.mdm.permis.api.domain.PermisUserRoleDO;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisUserRoleMapper {

    int delete(Integer id);

    int insert(PermisUserRoleDO record);

    int update(PermisUserRoleDO record);
}