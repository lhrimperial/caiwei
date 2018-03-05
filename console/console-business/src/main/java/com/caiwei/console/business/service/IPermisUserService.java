package com.caiwei.console.business.service;


import com.caiwei.console.persistent.domain.UserPO;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IPermisUserService {

    int insert(UserPO permisUserDO);

    int update(UserPO permisUserDO);

    int delete(int id);

    UserPO findPermisUser(String userCode);
}
