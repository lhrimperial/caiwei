package com.caiwei.framework.starter.configuration;

import org.springframework.context.annotation.Import;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 7:37
 */
@Import({DataSourceConfiguration.class,MybatisConfiguration.class, MyBatisScannerConfiguration.class})
public class MybatisAutoConfiguration {
}
