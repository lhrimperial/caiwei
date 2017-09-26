package com.caiwei.framework.starter.druid.autoconfigure;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

/**
 * @author longhairen
 * @create 2017/8/22 0022 下午 12:48
 */
@Configuration
@Import(DruidDataSourceSettings.class)
public class DataSourceConfig {

    @Autowired
    private DruidDataSourceSettings druidDataSourceSettings;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(druidDataSourceSettings.getDriverClassName());
        druidDataSource.setUrl(druidDataSourceSettings.getUrl());
        druidDataSource.setUsername(druidDataSourceSettings.getUsername());
        druidDataSource.setPassword(druidDataSourceSettings.getPassword());
        druidDataSource.setInitialSize(druidDataSourceSettings.getInitialSize());
        druidDataSource.setMinIdle(druidDataSourceSettings.getMinIdle());
        druidDataSource.setMaxActive(druidDataSourceSettings.getMaxActive());
        druidDataSource.setMaxWait(druidDataSourceSettings.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(druidDataSourceSettings.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(druidDataSourceSettings.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidDataSourceSettings.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidDataSourceSettings.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidDataSourceSettings.isTestOnBorrow());
        druidDataSource.setTestOnReturn(druidDataSourceSettings.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(druidDataSourceSettings.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceSettings.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setFilters(druidDataSourceSettings.getFilters());
        druidDataSource.setConnectProperties(druidDataSourceSettings.getConnectionProperties());
        return druidDataSource;
    }
}
