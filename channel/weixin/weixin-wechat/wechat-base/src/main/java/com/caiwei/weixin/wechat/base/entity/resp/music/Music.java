package com.caiwei.weixin.wechat.base.entity.resp.music;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author 龙海仁
 * @create：2016年1月9日 上午10:03:20
 * @description：
 */
public class Music {
	
	private String title;
	
	private String description;
	
	private String musicUrl;
	
	private String hqMusicUrl;
	
	private String thumbMediaId;

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

	@XmlElement(name="MusicUrl")
	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	@XmlElement(name="HQMusicUrl")
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
}

