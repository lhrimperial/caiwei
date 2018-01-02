package com.caiwei.weixin.wechat.news.message.impl;

import com.caiwei.framework.util.json.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ImageMsgHandler extends AbstractHandler{

	private Logger logger = Logger.getLogger(ImageMsgHandler.class);
	
	@Override
	public String getContent(Map<String, String> inputPara) {
		logger.debug(JsonUtils.toJson(inputPara));
		return "测试公众号：图片已收到！";
	}

	
}
