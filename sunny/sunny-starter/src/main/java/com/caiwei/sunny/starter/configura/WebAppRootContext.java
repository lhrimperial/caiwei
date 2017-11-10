package com.caiwei.sunny.starter.configura;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.util.WebAppRootListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
@Configuration
@EnableAutoConfiguration
public class WebAppRootContext implements EnvironmentAware,ServletContextInitializer {

    private Environment environment;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(WebAppRootListener.class);
        servletContext.setInitParameter("staticServerAddress", environment.getProperty("staticServerAddress"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
