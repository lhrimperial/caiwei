package com.caiwei.console.web.service;

import com.caiwei.console.common.domain.PermisUserDO;

/**
 *
 */
public interface ILoginService {

    PermisUserDO userLogin(String userCode, String password);
}
