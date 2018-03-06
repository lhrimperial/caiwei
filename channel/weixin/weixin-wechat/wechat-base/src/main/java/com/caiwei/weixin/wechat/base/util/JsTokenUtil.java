package com.caiwei.weixin.wechat.base.util;


import com.caiwei.weixin.wechat.base.define.WechatConst;
import com.caiwei.weixin.wechat.base.define.WechatUrl;
import com.caiwei.weixin.wechat.base.entity.token.JSApiTicket;
import com.caiwei.weixin.wechat.base.entity.token.JsToken;
import com.caiwei.weixin.wechat.base.util.net.WeixinUtil;
import com.github.framework.util.json.JsonUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;


public class JsTokenUtil {
	
	private static JSApiTicket js_ticket = null;
	public static String noncestr = null;
	public static String timestamp = null;
	
	/**
	 * 获取JS token
	 * @param targetUrl
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午11:01:07
	 * @update 
	 */
	public static JsToken genSign(String targetUrl){
		JsToken sign = new JsToken();
		sign.setAppid(WechatConst.APPID);
		sign.setSignature(JsTokenUtil.getSignature(targetUrl));
		sign.setNoncestr(JsTokenUtil.noncestr);
		sign.setTimestamp(JsTokenUtil.timestamp);
		return sign;
	}
	
	/**
	 * 获取签名
	 * @param url
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午11:02:19
	 * @update 
	 */
	public static String getSignature(String url) {
		String signature = null;
		noncestr = create_nonce_str();
		timestamp = create_timestamp();
		if(js_ticket == null || checkTicketTimeout(js_ticket)){
			js_ticket = getJsapiTicket();
		}else{
		}
		// 注意这里参数名必须全部小写，且必须有序
		String info = "jsapi_ticket=" + js_ticket.getTicket() + "&noncestr=" + noncestr
				+ "&timestamp=" + timestamp + "&url=" + url;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(info.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return signature;
	}
	
	private static boolean checkTicketTimeout(JSApiTicket ticket){
		boolean isOk = true;
		if((System.currentTimeMillis()/1000 - ticket.getCurrentTime()) > ticket.getExpires_in()){
			isOk = true;
		}else{
			isOk = false;
		}
		return  isOk;
	}
	
	/**
	 * 获取JS ticket
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午10:59:25
	 * @update 
	 */
	private static JSApiTicket getJsapiTicket(){
		String res = WeixinUtil.httpRequest(WechatUrl.JS_TICKET_URL.replace(WechatUrl.ACCESS_TOKEN,
				WeChatUtil.getToken()), "GET", null);
		JSApiTicket ticket = JsonUtils.toObject(res, JSApiTicket.class);
		ticket.setCurrentTime(System.currentTimeMillis()/1000);
		return ticket;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	
}
