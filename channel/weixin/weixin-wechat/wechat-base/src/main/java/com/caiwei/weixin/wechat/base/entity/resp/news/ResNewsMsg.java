package com.caiwei.weixin.wechat.base.entity.resp.news;




import com.caiwei.weixin.wechat.base.entity.resp.ResBaseMsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @ClassName:   NewsMsg 
 * @Description: 文本消息 新闻
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午5:50:39
 */
@XmlRootElement(name="xml")
public class ResNewsMsg extends ResBaseMsg {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3746766611500615530L;
	
	// 图文消息个数，限制为10条以内  
    private int articleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private ArticleList article;
    
    @XmlElement(name="ArticleCount")
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	@XmlElement(name="Articles")
	public ArticleList getArticle() {
		return article;
	}
	public void setArticle(ArticleList article) {
		this.article = article;
	}
}
