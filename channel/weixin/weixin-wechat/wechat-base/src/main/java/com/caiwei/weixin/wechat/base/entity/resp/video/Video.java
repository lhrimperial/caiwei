package com.caiwei.weixin.wechat.base.entity.resp.video;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:37:28
 * @description：
 */
public class Video {
	
	private String mediaId;
	
	private String title;
	
	private String description;

	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
