package com.caiwei.weixin.wechat.base.define;



import com.caiwei.framework.util.ConfigFileLoadUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * @author 龙海仁
 * @create：2015年12月15日 下午8:02:52
 * @description：
 */
public class WechatConst {

	public static final String DEFUALT_CONFIG_FILE_NAME = "config.properties";
	private String configFile = DEFUALT_CONFIG_FILE_NAME;


	public static Properties properties = null;

	static {
		try {
			properties = ConfigFileLoadUtil
					.getPropertiesForClasspath("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	//******************公众号**********************//
	/**
	 * 公众号APPID
	 */
	public static final String APPID = properties.getProperty("APPID");
	/**
	 * 公众号APPSECRET
	 */
	public static final String APPSECRET = properties.getProperty("APPSECRET");
	/**
	 * 
	 */
	public static final String WECHAT_TOKEN = properties.getProperty("WECHAT_TOKEN");
	/**
	 * 
	 */
	public static final String WECHAT_ENCODINGAESKEY = properties.getProperty("WECHAT_ENCODINGAESKEY");
}
