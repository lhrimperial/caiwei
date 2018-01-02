package com.caiwei.weixin.wechat.news.message;

import com.caiwei.weixin.wechat.base.define.MessageKey;
import com.caiwei.weixin.wechat.base.define.MsgKey;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 龙海仁
 * @create：2016年1月7日 下午9:44:40
 * @description：
 */
public class MsgDispatcher {
	
	protected static final Logger LOG = Logger.getLogger(MsgDispatcher.class);
	private static final Map<String, String> SERVICE_MAP = new HashMap<String, String>();
	static {
		// --------------------------消息----------------------------------
		SERVICE_MAP.put(MessageKey.REQ_MSG_TYPE_TEXT, "textMsgHandler");// 文本消息

		SERVICE_MAP.put(MessageKey.REQ_MSG_TYPE_IMAGE, "imageMsgHandler");// 图片消息

		SERVICE_MAP.put(MessageKey.REQ_MSG_TYPE_LOCATION, "locationMsgHandler");// 地理位置消息

		SERVICE_MAP.put(MessageKey.REQ_MSG_TYPE_VOICE, "voiceMsgHandler");// 音频消息
		
		SERVICE_MAP.put(MessageKey.REQ_MSG_TYPE_VIDEO, "videoMsgHandler");// 视频消息

		// --------------------------事件----------------------------------
		SERVICE_MAP.put(MessageKey.REQ_EVENT_TYPE_SUBSCRIBE, "subscribeEventHandler");// 订阅事件

		SERVICE_MAP.put(MessageKey.REQ_EVENT_TYPE_UNSUBSCRIBE, "unsubscribeEventHandler");// 取消订阅

	}
	
	/**
	 * 处理消息转发
	 * @param requestMap
	 * @param context
	 * @return
	 * @author 龙海仁
	 * @date 2016年1月7日
	 * @update 
	 */
	public static String dispatch(Map<String, String> requestMap,ApplicationContext context) {
		String msgType = requestMap.get(MsgKey.KEY_MSGTYPE);
		if (msgType.equals(MessageKey.REQ_MSG_TYPE_EVENT)) {
				//根据菜单的key，对每一个菜单响应
			String mapKey = requestMap.get(MsgKey.KEY_EVENT); 
			//跳转事件
			if(!SERVICE_MAP.keySet().contains(mapKey)){
				return "";
			}
            LOG.info("eventType:"+mapKey);
			IMsgHandler handler = (IMsgHandler)context.getBean(SERVICE_MAP.get(mapKey));
			return handler.handleMsg(requestMap);
		} else {
			LOG.info("msgType:" + msgType);
			IMsgHandler handler = (IMsgHandler) context.getBean(SERVICE_MAP.get(msgType));
			return handler.handleMsg(requestMap);
		}
	}

}
