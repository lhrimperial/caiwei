package com.caiwei.weixin.wechat.base.entity.resp.music;



import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author 龙海仁
 * @create：2016年1月9日 上午10:03:43
 * @description：
 */
@XmlRootElement(name="xml")
public class ResMusicMsg extends ResBaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3203069550128304917L;
	
	private Music music;

	@XmlElement(name="Music")
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	

}
