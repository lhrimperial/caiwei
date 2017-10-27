package com.caiwei.framework.starter.configuration.readwirte;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 5:37
 */
public class DatasourceContextHolder {
    public enum DatasourceType {
        MASTER,
        SLAVE
    }

    private static final ThreadLocal<DatasourceType> contextHolder = new ThreadLocal<>();

    public static void setDatasourceType(DatasourceType DatasourceType) {
        if(DatasourceType == null){
            throw new NullPointerException();
        }
        contextHolder.set(DatasourceType);
    }

    public static DatasourceType getDatasourceType() {
        return contextHolder.get() == null ? DatasourceType.MASTER : contextHolder.get();
    }

    public static void clearDatasourceType() {
        contextHolder.remove();
    }
}
