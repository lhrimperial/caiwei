package com.caiwei.framework.starter.configuration;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 7:18
 * 由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
 */

@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisScannerConfiguration implements EnvironmentAware{

    private static String basePackage;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(basePackage);//properties.getBasePackage());
        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        basePackage = environment.getProperty("mybatis.basePackage");
        if (StringUtils.isEmpty(basePackage)) {
            throw new IllegalArgumentException("mybatis basePackage is null");
        }
    }
}
