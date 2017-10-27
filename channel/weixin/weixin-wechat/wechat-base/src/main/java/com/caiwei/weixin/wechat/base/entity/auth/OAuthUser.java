package com.caiwei.weixin.wechat.base.entity.auth;

/**
 * @author 龙海仁
 * @create：2015年12月15日 下午10:19:38
 * @description：
 */
public class OAuthUser {
	
	/**
	 * 网页授权接口调用凭证
	 */
	private String access_token;
	
	/**
	 * 有效时间
	 */
	private Long expires_in;
	
	/**
	 * 用户刷新access_token 
	 */
	private String refresh_token;
	
	/**
	 * 用户openid
	 */
	private String openid;

	/**
	 * 用户授权的作用域
	 */
	private String scope;
	
	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	private String unionid;
	
	/**
	 * 获取token时刻的时间
	 */
	private Long currentTime;

	public Long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
}
