package com.caiwei.sunny.starter.util;


import com.caiwei.framework.server.shared.domain.Token;
import  org.apache.commons.codec.binary.Base64;

/**
 * 令牌序列化与反序列化
 * @author 龙海仁
 * @date 2015年6月23日
 */
final public class TokenMarshal {
	private TokenMarshal(){
	}

	/**
	 * 序列化(Base64编码)
	 * @param token
	 * @return
	 * @author 龙海仁
	 * @date 2015年6月23日
	 * @update 
	 */
	public static String marshal(Token token) {
		return new String(Base64.encodeBase64String(token.toBytes()));
	}

	/**
	 * 反序列化（Base64解码）
	 * @param tokenStr
	 * @return
	 * @author 龙海仁
	 * @date 2015年6月23日
	 * @update 
	 */
/*	public static Token unMarshal(String tokenStr) {
		return new Token(Base64.decodeBase64(tokenStr));
	}*/
}
