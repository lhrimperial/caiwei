package com.caiwei.console.common.context;

import com.caiwei.console.common.define.ConsoleConstants;
import com.caiwei.console.common.domain.PermisUserDO;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.context.UserContext;

/**
 *
 */
public class PermisUserContext {

    private PermisUserContext(){}

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

    /**
     * 获取当前用户设置的当前部门编码 getCurrentDeptCode
     *
     * @return String 当前部门编码
     * @since:
     */
    public static String getCurrentDeptCode() {
        return(String) SessionContext.getSession()
                .getObject(ConsoleConstants.KEY_CURRENT_DEPTCODE);
    }

    /**
     * 获取当前用户设置的当前部门名称 getCurrentDeptName
     *
     * @return String 当前部门名称
     * @since:
     */
    public static String getCurrentDeptName() {
        return(String) SessionContext.getSession()
                .getObject(ConsoleConstants.KEY_CURRENT_DEPTNAME);
    }

}
