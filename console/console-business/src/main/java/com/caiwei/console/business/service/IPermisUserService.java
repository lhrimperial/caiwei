package com.caiwei.console.business.service;


import com.caiwei.console.common.domain.PermisUserDO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IPermisUserService {

    int save(PermisUserDO permisUserDO);

    int update(PermisUserDO permisUserDO);

    int delete(String userCode);

    PermisUserDO findUserByLoginCode(String userCode);

    PermisUserDO findUserDetail(String userCode);

    List<PermisUserDO> findUsers(PermisUserDO userDO, int pageNo, int pageSize);

    List<PermisUserDO> findUsers(PermisUserDO userDO);

    void updateStatus(List<String> userCodes, Byte status);

    void updateUserRoleStatus(List<String> userCodes, Byte status);

}
