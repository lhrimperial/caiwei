package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.persistent.domain.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(UserPO permisUserDO);

    int update(UserPO permisUserDO);

    PermisUserDO findUserByLoginCode(String userCode);

    PermisUserDO findUserDetail(String userCode);


}