package com.caiwei.channel.weixin.wechat.web.configure;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getWechatServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());
        registrationBean.addUrlMappings("/wechat");
        return registrationBean;
    }
}
