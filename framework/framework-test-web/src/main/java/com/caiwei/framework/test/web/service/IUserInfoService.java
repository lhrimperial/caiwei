package com.caiwei.framework.test.web.service;



import com.caiwei.framework.test.web.domain.UserInfo;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:19
 */
public interface IUserInfoService {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserInfoList(int pageNO);
}
