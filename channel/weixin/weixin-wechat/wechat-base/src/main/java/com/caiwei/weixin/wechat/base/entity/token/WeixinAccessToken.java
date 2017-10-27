package com.caiwei.weixin.wechat.base.entity.token;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author 龙海仁
 * @create：2015年12月15日 下午7:47:57
 * @description：
 */
public class WeixinAccessToken implements Serializable {
	/**   */
	private static final long serialVersionUID = -4445395144890194966L;
	/** 凭证 */
	@JsonProperty(value="access_token")
	private String access_token;
	/** 有效时间 */
	@JsonProperty(value="expires_in")
	private Long expires_in;
	
	/**
	 * 获取到AccessToken时刻的时间
	 */
	private Long currentTime;

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

	public Long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}
	
	

}
