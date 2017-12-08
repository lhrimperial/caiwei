package com.caiwei.sunny.mdm.permis.mapper;

import com.caiwei.sunny.mdm.permis.api.domain.PermisRoleResourceDO;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisRoleResourceMapper {

    int delete(Integer id);

    int insert(PermisRoleResourceDO record);

    int update(PermisRoleResourceDO record);
}