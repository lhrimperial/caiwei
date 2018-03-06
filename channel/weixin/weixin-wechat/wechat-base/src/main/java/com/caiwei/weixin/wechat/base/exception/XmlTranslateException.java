package com.caiwei.weixin.wechat.base.exception;


import com.github.framework.server.exception.BusinessException;

public class XmlTranslateException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4114308063042762441L;
	
	public XmlTranslateException() {

	}

	public XmlTranslateException(String msg) {
		super(msg);
	}

	public XmlTranslateException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
