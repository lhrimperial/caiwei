package com.caiwei.weixin.wechat.base.entity.resp;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class ResBaseMsg implements Serializable {

	/**  */
	private static final long serialVersionUID = -5545811904878562659L;
	
	private String toUserName;
	private String fromUserName;
	private long createTime;
	private String msgType;
	
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
