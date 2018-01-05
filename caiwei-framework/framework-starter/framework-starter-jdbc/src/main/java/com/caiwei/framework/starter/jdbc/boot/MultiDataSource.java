package com.caiwei.framework.starter.jdbc.boot;

import com.caiwei.framework.starter.jdbc.DataSourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    public MultiDataSource() {
        setLenientFallback(false);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getCurrentDataSource();
    }
}
