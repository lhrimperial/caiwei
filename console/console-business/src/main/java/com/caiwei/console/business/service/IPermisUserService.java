package com.caiwei.console.business.service;


import com.caiwei.console.persistent.domain.UserPO;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IPermisUserService {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    int delete(String userCode);

    UserPO findUser(String userCode);
}
