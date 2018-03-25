package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.domain.UserVO;

/**
 *
 **/
public interface ISystemSetService {

    UserVO queryUserList(UserVO userVO);

    void addUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void deleteUser(UserVO userVO);

    RoleVO queryRoleList(RoleVO roleVO);

    void addRole(RoleVO roleVO);

    RoleVO findRole(RoleVO roleVO);

    void updateRole(RoleVO roleVO);

    void deleteRole(RoleVO roleVO);
}
