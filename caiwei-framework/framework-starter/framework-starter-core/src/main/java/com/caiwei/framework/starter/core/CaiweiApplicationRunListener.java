package com.caiwei.framework.starter.core;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author longhairen
 * @create 2018-01-03 23:59
 * @description
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CaiweiApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication springApplication;
    private ApplicationArguments applicationArguments;

    public CaiweiApplicationRunListener(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.applicationArguments = new DefaultApplicationArguments(args);
    }

    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Contexts.setEnvironment(environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        Contexts.setApplicationContext(context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {

    }
}
