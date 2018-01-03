
/*
 * 修订记录:
 * @author 钟勋 2017-11-22 18:52 创建
 */
package com.caiwei.frame.starter.jdbc.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 注解@DataSource自动配置类
 */
@Configuration
@EnableAspectJAutoProxy
@Import(DataSourceAspect.class)
public class DataSourceAspectAutoConfiguration {
}
