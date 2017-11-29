package com.caiwei.sunny.starter.service;


import com.caiwei.sunny.starter.domain.exception.LoginException;
import org.omg.CORBA.UserException;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
public interface ILoginService {

    void userLogin(String userCode, String password) throws LoginException, UserException;
}
