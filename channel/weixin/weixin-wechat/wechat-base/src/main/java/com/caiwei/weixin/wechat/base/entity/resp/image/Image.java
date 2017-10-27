package com.caiwei.weixin.wechat.base.entity.resp.image;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:28:53
 * @description：
 */
public class Image {

	private String mediaId;

	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	
}
