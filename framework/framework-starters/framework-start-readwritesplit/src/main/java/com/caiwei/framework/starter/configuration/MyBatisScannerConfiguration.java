package com.caiwei.framework.starter.configuration;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 7:18
 * 由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
 */

@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisScannerConfiguration implements EnvironmentAware{

    private String basePackage = "com.caiwei.**.mapper";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(basePackage);//properties.getBasePackage());
        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        String bpackage = environment.getProperty("mybatis.basePackage");
        if (bpackage != null && !bpackage.isEmpty()) {
            basePackage = bpackage;
        }
    }
}
