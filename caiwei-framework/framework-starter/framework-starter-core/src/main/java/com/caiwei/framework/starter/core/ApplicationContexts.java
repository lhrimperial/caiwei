package com.caiwei.framework.starter.core;

import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @author longhairen
 * @create 2018-01-03 23:49
 * @description
 * 应用上下文
 **/
public class ApplicationContexts {

    // spring环境
    private static ConfigurableEnvironment environment;
    // spring容器
    private static ConfigurableApplicationContext applicationContext;

    /**
     * 设置spring环境
     */
    public static void setEnvironment(ConfigurableEnvironment environment) {
        ApplicationContexts.environment = environment;
    }

    /**
     * 设置spring容器
     */
    public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        ApplicationContexts.applicationContext = applicationContext;
    }

    /**
     * 获取Environment
     */
    public static Environment getEnvironment() {
        if (getApplicationContext() == null) {
            return environment;
        } else {
            return getApplicationContext().getEnvironment();
        }
    }

    /**
     * 获取ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取被自动扫描的包路径
     */
    public static String[] getBasePackages() {
        List<String> basePackages = AutoConfigurationPackages.get(getApplicationContext());
        return basePackages.toArray(new String[basePackages.size()]);
    }

    /**
     * 获取当前环境
     */
    public static String getProfile() {
        return getEnvironment().getActiveProfiles()[0];
    }

    /**
     * 根据environment构建属性对象
     *
     * @param targetClass 目标类型
     * @return 属性对象
     */
    public static <T> T buildProperties(Class<T> targetClass) {
        PropertiesBinder binder = new PropertiesBinder(((ConfigurableEnvironment) getEnvironment()).getPropertySources());
        return binder.build(targetClass);
    }
}
