package com.caiwei.framework.starter.mybatis.autoconfigure;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 7:18
 * 由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
 */

@Configuration
@AutoConfigureAfter(MybatisSqlSessionConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.caiwei.**.mapper");
        return mapperScannerConfigurer;
    }

}
