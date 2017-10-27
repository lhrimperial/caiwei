package com.caiwei.weixin.wechat.base.define;

/**
 * @author 龙海仁
 * @create：2015年12月14日 下午11:28:40
 * @description：
 */
public class WechatUrl {
	
	/**
	 * 
	 */
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	
	/**
	 * 获取AccessToken GET
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 获取网页授权Token
	 */
	public static final String WEB_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	/**
	 * 刷新access_token
	 */
	public static final String WEB_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}";
	
	/**
	 * 获取js ticket
	 */
	public static final String JS_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/**
	 * 获取用户基本信息 GET
	 */
	public static final String WECHAT_USER_BASE_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}";
	
	/**
	 * 创建菜单
	 */
	public static final String CREATE_MUNE_URL = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
	
	/**
	 * 发送模板消息
	 */
	public static final String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={0}";
	
	/**
	 * 临时二维码
	 */
	public static final String QR_SCENE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={0}";
	
	/**
	 * 通过ticket换取二维码
	 */
	public static final String EXCHANGE_QR = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={0}";

	
	//分享特殊处理URL
	public static String[] urls = new String[]{"recuitNextAction.action","recomSearchActoin!searchJobDetail.action","firstResumeActoin!index.action",
		"fillResumeActoin!submitBase.action"};

}
