package com.caiwei.framework.starter.mybatis.autoconfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 7:01
 */
@Configuration
@Import({MybatisSqlSessionConfig.class,MyBatisMapperScannerConfig.class})
public class MybatisAutoConfiguration {


}
