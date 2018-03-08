package com.caiwei.console.common.exception;


import com.github.framework.server.exception.BusinessException;

/**
 * 与资源信息有关的异常
 */
public class ResourceException extends BusinessException {

	private static final long serialVersionUID = -1982586715098015347L;

	/**
	 * 资源编码列表为空
	 */
	public static final String RESOURCE_CODE_LIST_NULL = "bse.resource.ResourceCodeListNullException";

	/**
	 * 资源URI为空
	 */
	public static final String RESOURCE_URI_NULL =  "bse.resource.ResourceUriNullException";
	
	/**
	 * 资源列表为空
	 */
	public static final String RESOURCES_NULL =  "bse.resource.ResourceNullException";

	/**
	 * 资源编码为空
	 */
	public static final String RESOURCE_CODE_NULL = "bse.resource.ResourceCodeNullException";
	

	/**
	 * 权限编码已存在
	 */
	public static final String RESOURCE_CODE_EXIST = "bse.resource.ResourceCodeExistException";


	/**
	 * 权限入口已存在
	 */
	public static final String ENTRY_URI_EXIST = "bse.resource.ResourceEntryUriExistException";

	/**
	 * 权限入口为空
	 */
	public static final String RESOURCE_ENTRY_URI_NULL = "bse.resource.ResourceEntryUriNullException";
	
	
	public ResourceException(String errCode){
		super(errCode);
		super.errCode = errCode;
	}	
	
	public ResourceException(String code, String msg){
		super(code,msg);
	}
}
