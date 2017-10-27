package com.caiwei.weixin.wechat.base.util;

import com.caiwei.framework.common.exception.BusinessException;
import com.caiwei.framework.util.json.JsonUtils;
import com.caiwei.framework.util.string.StringUtils;
import com.caiwei.weixin.wechat.base.define.WechatConst;
import com.caiwei.weixin.wechat.base.define.WechatUrl;
import com.caiwei.weixin.wechat.base.entity.auth.OAuthUser;
import com.caiwei.weixin.wechat.base.util.net.WeixinUtil;
import org.apache.log4j.Logger;

/**
 * @author 龙海仁
 * @create：2015年12月15日 下午8:24:19
 * @description：
 */
public class OpenidUtil {
	
	private static Logger log = Logger.getLogger(OpenidUtil.class);
	
	public static OAuthUser oauthUser = null;
	
	/**
	 * 获取AccessToken
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午8:13:44
	 * @update 
	 */
	public static String getToken(){
		
		String web_token = "";
		if(oauthUser == null || checkAccessTokenTimeOut(oauthUser)){
			oauthUser = refreshToken();
			web_token = oauthUser.getAccess_token();
		}else{
			web_token = oauthUser.getAccess_token();
		}
		return web_token;
	}
	
	public static OAuthUser refreshToken(){
		String url = StringUtils.formart(WechatUrl.WEB_REFRESH_TOKEN_URL, WechatConst.APPID,oauthUser.getRefresh_token());
		String jsonStr = WeixinUtil.httpRequest(url, "GET", null);
		log.info("get openid return json Str:"+jsonStr);
		if(jsonStr.contains("errcode") || jsonStr.contains("40029")){
//			throw new BusinessException("invalid code");
		}
		OAuthUser oauth = JsonUtils.toObject(jsonStr, OAuthUser.class);
		oauth.setCurrentTime(System.currentTimeMillis() / 1000);
		return oauth;
	}
	
	/**
	 * @Title: checkAccessTokenTimeOut 
	 * @Description:检测AccessToken是否过期
	 * @param oauthUser
	 * @return
	 */
	private static boolean checkAccessTokenTimeOut(OAuthUser oauthUser) {
		boolean isOk = true;
		long currentTime = System.currentTimeMillis() / 1000;
		long differece = currentTime - oauthUser.getCurrentTime();
		if (differece > oauthUser.getExpires_in()) {
			isOk = true;
		} else {
			isOk = false;
		}
		return isOk;
	}
	
	
	
	/**
	 * 获取OpenId
	 * @param code
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午10:41:57
	 * @update 
	 */
	public static String getOpenId(String code){
		log.info("code:"+code);
		String url = WechatUrl.WEB_ACCESS_TOKEN_URL.replace("APPID", WechatConst.APPID)
				.replaceAll("SECRET", WechatConst.APPSECRET).replace("CODE", code);
		log.info("get openid request url:"+url);
		String jsonStr = WeixinUtil.httpRequest(url, "GET", null);
		log.info(jsonStr);
		if(jsonStr.contains("errcode")){
			throw new BusinessException("openid is null");
		}
		log.info("get openid return json Str:"+jsonStr);
		oauthUser = JsonUtils.toObject(jsonStr, OAuthUser.class);
		oauthUser.setCurrentTime(System.currentTimeMillis() / 1000);
		log.info("openid:"+oauthUser.getOpenid());
		return oauthUser.getOpenid();
//		return "oniwLs2tKUNrRf45dOBpWOmBGELA"	;
	}
	

}
