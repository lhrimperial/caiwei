package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.UserVO;

/**
 *
 **/
public interface IUserService {

    UserVO queryUserList(UserVO userVO);

    void addUser(UserVO userVO);

    void deleteUser(UserVO userVO);
}
