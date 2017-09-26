package com.caiwei.framework.starter.druid.autoconfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author longhairen
 * @create 2017/8/25 0025 下午 3:04
 */
@Configuration
@Import({DataSourceConfig.class,
        DruidStatViewServletConfig.class,
        DruidWebStatFilterConfig.class})
public class DruidAutoConfiguration {
}
