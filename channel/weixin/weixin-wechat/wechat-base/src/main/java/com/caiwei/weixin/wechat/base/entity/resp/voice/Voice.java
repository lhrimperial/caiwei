package com.caiwei.weixin.wechat.base.entity.resp.voice;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:34:34
 * @description：
 */
public class Voice {

	private String mediaId;

	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	
}
