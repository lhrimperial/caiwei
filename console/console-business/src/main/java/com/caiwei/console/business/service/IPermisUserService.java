package com.caiwei.console.business.service;


import com.caiwei.console.common.domain.PermisUserDO;

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
}
