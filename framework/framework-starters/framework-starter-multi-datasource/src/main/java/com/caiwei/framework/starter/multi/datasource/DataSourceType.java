package com.caiwei.framework.starter.multi.datasource;


/**
 * @author longhairen
 * @create 2017/10/27 0027 下午 4:53
 */
public enum  DataSourceType {
    read("read", "从库"), write("write", "主库");
    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
