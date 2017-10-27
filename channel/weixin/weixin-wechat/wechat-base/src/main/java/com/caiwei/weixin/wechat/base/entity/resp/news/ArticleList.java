package com.caiwei.weixin.wechat.base.entity.resp.news;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 
 * @author 龙海仁
 * @date 2016年1月9日上午10:14:14
 */
public class ArticleList {
	
	private List<Article> item;

	@XmlElement(name="item")
	public List<Article> getItem() {
		return item;
	}

	public void setItem(List<Article> item) {
		this.item = item;
	}
}
