package com.caiwei.weixin.wechat.base.define;

/**
 * @author 龙海仁
 * @create：2016年1月7日 下午9:12:20
 * @description：
 */
public class MessageKey {

	/**
	 * 文本消息
	 */
	public static final String REQ_MSG_TYPE_TEXT = "text";
	/**
	 * 图片消息
	 */
	public static final String REQ_MSG_TYPE_IMAGE = "image";
	/**
	 * 语音消息
	 */
	public static final String REQ_MSG_TYPE_VOICE = "voice";
	/**
	 * 视频消息
	 */
	public static final String REQ_MSG_TYPE_VIDEO = "video";
	/**
	 * 小视频消息
	 */
	public static final String REQ_MSG_TYPE_SHORTVIDEO = "shortvideo";
	/**
	 * 地理位置消息
	 */
	public static final String REQ_MSG_TYPE_LOCATION = "location";
	/**
	 * 链接消息
	 */
	public static final String REQ_MSG_TYPE_LINK = "link";
	
	/**
	 * 事件
	 */
	public static final String REQ_MSG_TYPE_EVENT = "event";
	
	/**
	 * subscribe(订阅)
	 */
	public static final String REQ_EVENT_TYPE_SUBSCRIBE = "subscribe";
	
	/**
	 * unsubscribe(取消订阅) 
	 */
	public static final String REQ_EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	
	
	/**
	 * 扫描带参数二维码事件
	 */
	public static final String REQ_EVENT_TYPE_SCAN = "SCAN";
	
	/**
	 * 上报地理位置事件
	 */
	public static final String REQ_EVENT_TYPE_LOCATION = "LOCATION";
	
	/**
	 * 自定义菜单事件
	 */
	public static final String REQ_EVENT_TYPE_CLICK = "CLICK";
	
	/**
	 * 点击菜单跳转链接时的事件推送 
	 */
	public static final String REQ_EVENT_TYPE_VIEW = "VIEW";
	
	//************************************************************************//
	
	/**
	 * 回复文本消息
	 */
	public static final String RESP_MSG_TYPE_TEXT = "text";
	/**
	 * 回复图片消息
	 */
	public static final String RESP_MSG_TYPE_IMAGE = "image";
	/**
	 * 回复语音消息
	 */
	public static final String RESP_MSG_TYPE_VOICE = "voice";
	/**
	 * 回复视频消息
	 */
	public static final String RESP_MSG_TYPE_VIDEO = "video";
	
	/**
	 * 回复音乐消息
	 */
	public static final String RESP_MSG_TYPE_MUSIC = "music";
	
	/**
	 * 回复图文消息
	 */
	public static final String RESP_MSG_TYPE_NEWS = "news";
}
