package com.caiwei.sunny.starter.context;

import com.caiwei.framework.server.cache.exception.security.UserNotLoginException;
import com.caiwei.framework.server.context.UserContext;
import com.caiwei.sunny.starter.domain.PermisUserBO;

/**
 * @author longhr
 * @version 2017/11/8 0008
 */
public class SunnyUserContext {

    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static PermisUserBO getCurrentUser() {
        PermisUserBO user = (PermisUserBO) (UserContext.getCurrentUser());
        if (user == null) {
            throw new UserNotLoginException();
        }
        return user;
    }
}
