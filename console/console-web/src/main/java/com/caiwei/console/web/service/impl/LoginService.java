package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.common.exception.LoginException;
import com.caiwei.console.common.exception.UserException;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.web.service.ILoginService;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.cryp.CryptoUtil;
import com.github.framework.util.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class LoginService implements ILoginService {

    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public PermisUserDO userLogin(String userCode, String password) {
        //验证用户
        PermisUserDO userDO = validate(userCode, password);
        // 把登录用户ID、工号与默认部门编码存入session中
        // 存入用户ID
        SessionContext.setCurrentUser(userDO.getUserCode());
        return userDO;
    }

    private PermisUserDO validate(String userName, String password)
            throws LoginException, UserException {
        if (StringUtils.isBlank(userName)) {
            throw new LoginException(LoginException.USER_NAME_NULL);
        }
        if (StringUtils.isBlank(password)) {
            throw new LoginException(LoginException.USER_PASSWORD_NULL);
        }
        // 应用OA的加密方式
        password = CryptoUtil.getInstance().getMD5ofStr(password);
        PermisUserDO userPO = permisUserService.findUserByLoginCode(userName);
        if (userPO == null) {
            throw new LoginException(LoginException.USER_NULL);
        }
        // 如果用户已经被禁用，则不能登录
        if (Constants.PO_ACTIVE != userPO.getStatus()) {
            throw new LoginException(LoginException.USER_DISABLE);
        }
        if (!password.equals(userPO.getPassWord())) {
            throw new LoginException(LoginException.USER_PASSWORD_ERROR);
        }
         //通过用户ID得到用户的完整信息
        userPO = permisUserService.findUserDetail(userName);
        // 如果用户为空，则用户没有配置角色
        if (userPO == null) {
            throw new LoginException(LoginException.CURRENT_USER_NO_ROLE);
        }
        return userPO;
    }
}
