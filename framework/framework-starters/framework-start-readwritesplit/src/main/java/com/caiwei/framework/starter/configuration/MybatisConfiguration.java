package com.caiwei.framework.starter.configuration;

import com.caiwei.framework.starter.configuration.readwirte.DatasourceContextHolder;
import com.caiwei.framework.starter.configuration.readwirte.ReadWriteSplitRoutingDataSource;
import com.caiwei.framework.util.SpringContextHolder;
import com.caiwei.framework.util.db.dialect.MySQLDialect;
import com.caiwei.framework.util.db.helper.OffsetLimitInterceptor;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 5:55
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
@Import({MybatisConfProperties.class})
public class MybatisConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Autowired
    private MybatisConfProperties properties;

    @Autowired
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;
    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(roundRobinDataSouceProxy());
//        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(properties.getConfigLocation()));
        }
        if (StringUtils.hasLength(properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(properties.getTypeHandlersPackage());
        }
        Resource[] mapperLocationsResources = properties.resolveMapperLocations();
        if (!ObjectUtils.isEmpty(mapperLocationsResources)) {
            factory.setMapperLocations(mapperLocationsResources);
        }

        //分页插件
        OffsetLimitInterceptor interceptor = new OffsetLimitInterceptor();
        interceptor.setDialect(new MySQLDialect());

        //添加插件
        factory.setPlugins(new Interceptor[]{interceptor});
        return factory.getObject();
    }

    @Bean
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        Map<Object, Object> targetDataResources = new ConcurrentHashMap<Object,Object>();
        targetDataResources.put(DatasourceContextHolder.DatasourceType.MASTER, new Log4jdbcProxyDataSource(masterDataSource));
        targetDataResources.put(DatasourceContextHolder.DatasourceType.SLAVE, new Log4jdbcProxyDataSource(slaveDataSource));
        proxy.setDefaultTargetDataSource(masterDataSource);//默认源
        proxy.setTargetDataSources(targetDataResources);
        return proxy;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManagers() {
        return new DataSourceTransactionManager((DataSource) SpringContextHolder.getBean("roundRobinDataSouceProxy"));
    }
}