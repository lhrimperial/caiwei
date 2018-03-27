package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.domain.UserVO;

/**
 *
 **/
public interface ISystemSetService {
    /**
     * user set
     */
    UserVO findUserById(UserVO userVO);

    UserVO queryUserList(UserVO userVO);

    void addUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void deleteUser(UserVO userVO);

    /**
     * role config
     */
    UserVO queryUserDept(UserVO userVO);

    RoleVO queryOrgRoleByUserCode(UserVO userVO);

    RoleVO queryAllRole(RoleVO roleVO);

    void updateUserOrgRole(UserVO userVO);

    /**
     * role set
     */
    RoleVO queryRoleList(RoleVO roleVO);

    void addRole(RoleVO roleVO);

    RoleVO findRole(RoleVO roleVO);

    void updateRole(RoleVO roleVO);

    void deleteRole(RoleVO roleVO);
}
