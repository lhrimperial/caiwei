package com.caiwei.weixin.wechat.base.util.net;

/** 
* @ClassName  :AuthUtil 
* @Description:从微信的view 类型的菜单跳转到自己的应用一些授权操作
* @author     :xujun cometzb@126.com	
* @date       :2014年4月25日 上午9:39:26 
*  
*/
public class AuthUtil {
	
	public static String genAuthUrl(String appid, String redirectUrl){
		StringBuilder sb = new StringBuilder();
		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		sb.append(appid);
		sb.append("&redirect_uri=");
		sb.append(redirectUrl);
		sb.append("&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect");
		return sb.toString();
	}
	
	
//	snsapi_userinfo
	public static String genAuthUrlUserInfo(String appid, String redirectUrl){
		StringBuilder sb = new StringBuilder();
		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		sb.append(appid);
		sb.append("&redirect_uri=");
		sb.append(redirectUrl);
		sb.append("&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect");
		return sb.toString();
	}
	
	
}
