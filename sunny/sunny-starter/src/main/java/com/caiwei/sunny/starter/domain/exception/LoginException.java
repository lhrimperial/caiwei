package com.caiwei.sunny.starter.domain.exception;


import com.caiwei.framework.server.exception.BusinessException;

public class LoginException extends BusinessException {

	private static final long serialVersionUID = -4375232641764945199L;
	
	/**
	 * 登录密码不能为空
	 */
	public static final String USER_PASSWORD_NULL = "caiwei.login.UserPasswordNullException";

	/**
	 * 登录密码错误
	 */
	public static final String USER_PASSWORD_ERROR = "caiwei.login.UserPasswordErrorException";

	/**
	 * 该用户不存在
	 */
	public static final String USER_NULL = "caiwei.login.UserNullException";

	/**
	 * 用户名不能为空
	 */
	public static final String USER_NAME_NULL = "caiwei.login.UserNameNullException";

	/**
	 * 当前用户已经被禁用
	 */
	public static final String USER_DISABLE = "caiwei.login.UserIsDisableException";

	/**
	 * 当前用户部门编码不能为空
	 */
	public static final String CURRENT_USER_DEPT_CODE_NULL = "caiwei.login.CurrentUserDeptCodeException";

	/**
	 * 当前部门不存在
	 */
	public static final String CURRENT_DEPT_ISNOT_EXIST = "caiwei.login.CurrentDeptIsNotExistException";
	
	/**
	 * 所属部门未配置角色信息
	 */
	public static final String CURRENT_DEPT_NO_ROLE = "caiwei.login.currentDeptNoRoleInfo";
	
	/**
	 * 当前用户未配置角色信息
	 */
	public static final String CURRENT_USER_NO_ROLE = "caiwei.login.currentUserNoRoleInfo";
	
	public LoginException(String errCode){
		super();
		super.errCode = errCode;
	}
}
