package com.caiwei.business.user.api.service;


import com.caiwei.business.user.api.domain.UserPO;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:28
 */
public interface IUserService {

    UserPO findUserByCode(String userCode);
}
