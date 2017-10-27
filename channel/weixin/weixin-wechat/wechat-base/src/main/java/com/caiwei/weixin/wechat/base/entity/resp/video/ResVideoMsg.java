package com.caiwei.weixin.wechat.base.entity.resp.video;



import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:36:53
 * @description：
 */
@XmlRootElement(name="xml")
public class ResVideoMsg extends ResBaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7080082035961107632L;
	
	private Video video;

	@XmlElement(name="Video")
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	

}
