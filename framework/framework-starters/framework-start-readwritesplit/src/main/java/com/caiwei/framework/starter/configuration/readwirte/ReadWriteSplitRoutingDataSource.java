package com.caiwei.framework.starter.configuration.readwirte;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 5:36
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceContextHolder.getDatasourceType();
    }
}
