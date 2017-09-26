package com.caiwei.framework.starter.mybatis.autoconfigure;

import com.caiwei.framework.starter.druid.autoconfigure.DataSourceConfig;
import com.caiwei.framework.starter.mybatis.dialect.MySQLDialect;
import com.caiwei.framework.starter.mybatis.helper.OffsetLimitInterceptor;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 7:01
 */
@Configuration
@EnableTransactionManagement
@Import({DataSourceConfig.class})
public class MybatisSqlSessionConfig implements TransactionManagementConfigurer {

    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        bean.setDataSource(new Log4jdbcProxyDataSource(dataSource));

        //分页插件
        OffsetLimitInterceptor interceptor = new OffsetLimitInterceptor();
        interceptor.setDialect(new MySQLDialect());

        //添加插件
        bean.setPlugins(new Interceptor[]{interceptor});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/caiwei/**/mapper/*Mapper.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
