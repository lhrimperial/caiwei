package com.caiwei.console.web.configure;

import com.github.framework.server.web.filter.FrameworkFilter;
import com.github.framework.server.web.listener.AppContextListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class WebInitializeConfiguration {

    @Bean
    public ServletListenerRegistrationBean getAppContextListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new AppContextListener());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getFrameworkFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FrameworkFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
