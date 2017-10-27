package com.caiwei.weixin.wechat.base.entity.resp.voice;



import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:33:54
 * @description：
 */
@XmlRootElement(name="xml")
public class ResVoiceMsg extends ResBaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 338250885442541050L;
	
	private Voice voice;

	@XmlElement(name="Voice")
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	

}
