package com.caiwei.weixin.wechat.base.util;

import com.caiwei.framework.util.json.JsonUtils;
import com.caiwei.weixin.wechat.base.define.WechatConst;
import com.caiwei.weixin.wechat.base.define.WechatUrl;
import com.caiwei.weixin.wechat.base.entity.token.WeixinAccessToken;
import com.caiwei.weixin.wechat.base.util.net.WeixinUtil;
import org.apache.log4j.Logger;


/**
 * @author 龙海仁
 * @create：2015年12月15日 下午8:12:36
 * @description：
 */
public class WeChatUtil {
	
	/**
	 * 
	 */
	public static WeixinAccessToken ACCESSTOKEN = null;
	
	private static Logger logger = Logger.getLogger(WeChatUtil.class);
	
	/**
	 * 获取AccessToken
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午8:13:44
	 * @update 
	 */
	public static String getToken(){
		String accessToken = "";
		if(ACCESSTOKEN == null || checkAccessTokenTimeOut(ACCESSTOKEN)){
			ACCESSTOKEN = queryAccessToken();
			accessToken = ACCESSTOKEN.getAccess_token();
		}else{
			accessToken = ACCESSTOKEN.getAccess_token();
		}
		return accessToken;
	}
	
	/**
	 * @Title: checkAccessTokenTimeOut 
	 * @Description:检测AccessToken是否过期
	 * @param accessToken
	 * @return
	 */
	private static boolean checkAccessTokenTimeOut(WeixinAccessToken accessToken) {
		boolean isOk = true;
		long currentTime = System.currentTimeMillis() / 1000;
		long differece = currentTime - accessToken.getCurrentTime();
		if (differece > accessToken.getExpires_in()) {
			isOk = true;
		} else {
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * 获取微信AccessToken
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午8:21:46
	 * @update 
	 */
	private static WeixinAccessToken queryAccessToken() {
		String token = WeixinUtil.httpRequest(
				WechatUrl.ACCESS_TOKEN_URL.replace("APPID", WechatConst.APPID)
						.replace("APPSECRET", WechatConst.APPSECRET), "GET", null);
		logger.info(token);
		WeixinAccessToken accessToken = JsonUtils.toObject(token,
				WeixinAccessToken.class);
		accessToken.setCurrentTime(System.currentTimeMillis() / 1000);
		
		return accessToken;
	}
	

}
