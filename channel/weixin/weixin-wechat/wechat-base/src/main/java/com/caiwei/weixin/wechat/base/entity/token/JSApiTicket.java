package com.caiwei.weixin.wechat.base.entity.token;

import org.codehaus.jackson.annotate.JsonProperty;

/**
* @ClassName: JSApiTicket
* @Description:js_ticket
* @author hairen.long@hoau.net
* @date 2015年6月10日 上午10:27:21
*/
public class JSApiTicket {
	@JsonProperty(value="errcode")
	private int errcode;
	@JsonProperty(value="errmsg")
	private String errmsg;
	@JsonProperty(value="ticket")
	private String ticket;
	@JsonProperty(value="expires_in")
	private long expires_in;
	private long currentTime;
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	
}
