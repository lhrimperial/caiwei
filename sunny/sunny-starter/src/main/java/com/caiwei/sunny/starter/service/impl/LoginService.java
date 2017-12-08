package com.caiwei.sunny.starter.service.impl;

import com.caiwei.framework.util.cryp.CryptoUtil;
import com.caiwei.framework.util.string.StringUtils;
import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;
import com.caiwei.sunny.mdm.permis.api.service.IPermisUserService;
import com.caiwei.sunny.starter.domain.define.SunnyConstants;
import com.caiwei.sunny.starter.domain.exception.LoginException;
import com.caiwei.sunny.starter.service.ILoginService;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public void userLogin(String userCode, String password) throws LoginException, UserException{
        // 验证用户
        PermisUserDO user = validate(userCode, password);
    }

    private PermisUserDO validate(String userCode, String password)
            throws LoginException, UserException {
        if (StringUtils.isBlank(userCode)) {
            throw new LoginException(LoginException.USER_NAME_NULL);
        }
        if (StringUtils.isBlank(password)) {
            throw new LoginException(LoginException.USER_PASSWORD_NULL);
        }
        // 应用OA的加密方式
        password = CryptoUtil.getInstance().getMD5ofStr(password);
        PermisUserDO user = permisUserService.findPermisUser(userCode);
        if (user == null) {
            throw new LoginException(LoginException.USER_NULL);
        }
        // 如果用户已经被禁用，则不能登录
        if (!SunnyConstants.ACTIVE_NUM.equals(user.getStatus())) {
            throw new LoginException(LoginException.USER_DISABLE);
        }
        if (!password.equals(user.getPassWord())) {
            throw new LoginException(LoginException.USER_PASSWORD_ERROR);
        }
        // 通过用户ID得到用户的完整信息
//        user = userService.queryUserByUserName(userName);
        // 如果用户为空，则用户没有配置角色
        if (user == null) {
            throw new LoginException(LoginException.CURRENT_USER_NO_ROLE);
        }
        return user;
    }
}
