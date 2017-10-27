package com.caiwei.weixin.wechat.base.entity.token;

/**
 * @author 龙海仁
 * @create：2015年12月4日 下午11:13:43
 * @description：
 */
public class JsToken {
	private String appid;
	private String timestamp;
	private String noncestr;
	private String signature;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	

}
