package com.caiwei.console.common.exception;

import com.github.framework.server.exception.BusinessException;

/**
 *
 */
public class LoginException extends BusinessException {
    private static final long serialVersionUID = 2214646113344712229L;

    /**
     * 登录密码不能为空
     */
    public static final String USER_PASSWORD_NULL = "登录密码不能为空";//"login.UserPasswordNullException";

    /**
     * 登录密码错误
     */
    public static final String USER_PASSWORD_ERROR = "登录密码错误";//"login.UserPasswordErrorException";

    /**
     * 该用户不存在
     */
    public static final String USER_NULL = "该用户不存在";//"login.UserNullException";

    /**
     * 用户名不能为空
     */
    public static final String USER_NAME_NULL = "用户名不能为空";//"login.UserNameNullException";

    /**
     * 当前用户已经被禁用
     */
    public static final String USER_DISABLE = "当前用户已经被禁用";//"login.UserIsDisableException";

    /**
     * 当前用户部门编码不能为空
     */
    public static final String CURRENT_USER_DEPT_CODE_NULL = "当前用户部门编码不能为空";//"login.CurrentUserDeptCodeException";

    /**
     * 当前部门不存在
     */
    public static final String CURRENT_DEPT_ISNOT_EXIST = "当前部门不存在";//"login.CurrentDeptIsNotExistException";

    /**
     * 所属部门未配置角色信息
     */
    public static final String CURRENT_DEPT_NO_ROLE = "所属部门未配置角色信息";//"login.currentDeptNoRoleInfo";

    /**
     * 当前用户未配置角色信息
     */
    public static final String CURRENT_USER_NO_ROLE = "当前用户未配置角色信息";//"login.currentUserNoRoleInfo";

    public LoginException(String errCode){
        super();
        super.errCode = errCode;
    }
}
