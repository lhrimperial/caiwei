package com.caiwei.sunny.mdm.permis.mapper;

import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisUserMapper {

    int insert(PermisUserDO permisUserDO);

    int update(PermisUserDO permisUserDO);

    int delete(int id);

    PermisUserDO findByUserCode(String loginName);


}