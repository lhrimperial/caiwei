package com.caiwei.weixin.wechat.base.entity.resp.image;



import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author 龙海仁
 * @create：2016年1月9日 上午9:25:24
 * @description：
 */
@XmlRootElement(name="xml")
public class ResImageMsg extends ResBaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5664107609194361893L;
	
	private Image image;

	@XmlElement(name="Image")
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
