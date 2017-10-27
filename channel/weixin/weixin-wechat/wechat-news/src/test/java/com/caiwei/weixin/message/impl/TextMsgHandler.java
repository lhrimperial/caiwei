package com.caiwei.weixin.message.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TextMsgHandler extends AbstractHandler{

	@Override
	public String getContent(Map<String, String> inputPara) {
		return "测试公众号：你的消息已收到！";
	}
	
}
