package com.caiwei.weixin.wechat.base.util.net;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
* @ClassName: MyX509TrustManager
* @Description: 
* @author 275688
* @date 2015年1月16日 上午10:51:20*
*/ 
public class MyX509TrustManager implements X509TrustManager {

	
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		
	}

	public X509Certificate[] getAcceptedIssuers() {

		return null;
	}
	
}
