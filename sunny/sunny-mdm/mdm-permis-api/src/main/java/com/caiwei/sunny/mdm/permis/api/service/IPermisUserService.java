package com.caiwei.sunny.mdm.permis.api.service;

import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IPermisUserService {

    int insert(PermisUserDO permisUserDO);

    int update(PermisUserDO permisUserDO);

    int delete(int id);

    PermisUserDO findPermisUser(String userCode);
}
