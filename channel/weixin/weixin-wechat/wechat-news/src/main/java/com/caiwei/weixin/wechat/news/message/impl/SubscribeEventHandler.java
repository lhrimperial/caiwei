package com.caiwei.weixin.wechat.news.message.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 处理关注事件
 * SubscribeEventHandler
 * @author 龙海仁
 * @date 2016年3月25日上午9:54:11 
 */
@Service
public class SubscribeEventHandler extends AbstractHandler{
	
	private Logger logger = Logger.getLogger(SubscribeEventHandler.class);
	
	@Override
	public String getContent(Map<String, String> inputPara) {
		//返回消息
		StringBuilder sb = new StringBuilder();
		sb.append("欢迎关注！ /::)\r\n");
		logger.info(sb.toString());
		return sb.toString();
	}
	
}
