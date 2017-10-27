package com.caiwei.weixin.wechat.base.entity.resp.text;



import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="xml")
public class ResTextMsg extends ResBaseMsg {

	/**  */
	private static final long serialVersionUID = -4921586639172373081L;
	
	private String content ;

	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
