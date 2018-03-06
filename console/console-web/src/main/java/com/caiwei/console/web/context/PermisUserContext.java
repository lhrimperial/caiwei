package com.caiwei.console.web.context;

import com.caiwei.console.common.domain.PermisUserDO;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.UserContext;

/**
 *
 */
public class PermisUserContext {
    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static PermisUserDO getCurrentUser() {
        PermisUserDO user = (PermisUserDO) (UserContext.getCurrentUser());
        if (user == null) {
            throw new UserNotLoginException();
        }
        return user;
    }
}
