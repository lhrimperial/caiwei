package com.caiwei.weixin.wechat.base.entity.token;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * 
 * QrTicket
 * @author 龙海仁
 * @create：2016年6月19日 下午4:48:31 
 */
public class QrTicket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4091616847416637876L;
	
	@JsonProperty(value="ticket")
	private String ticket;//	获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	
	@JsonProperty(value="expire_seconds")
	private long expire_seconds;//	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	
	@JsonProperty(value="url")
	private String url;//	二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	
	private long  currentTime;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	
	
}
