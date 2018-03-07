package com.caiwei.console.common.domain;

import com.github.framework.server.shared.entity.BaseEntity;
import com.github.framework.server.shared.entity.IFunction;
import com.github.framework.server.shared.entity.IModule;

import java.util.List;

/**
 * 权限业务实体
 */
public class ResourceDO  extends BaseEntity implements IFunction {

    /**
     * 功能编码
     */
    private String code;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 功能入口URI
     */
    private String entryUri;

    /**
     * 功能层次
     */
    private String resLevel;

    /**
     * 父功能
     */
    private ResourceDO parentResDO;

    /**
     * 是否有效
     */
    private String active;

    /**
     * 显示顺序
     */
    private String displayOrder;

    /**
     * 是否权限检查
     */
    private String checked;

    /**
     * 功能类型
     */
    private String resType;

    /**
     * 是否叶子节点
     */
    private String leafFlag;

    /**
     * 图标的CSS样式
     */
    private String iconCls;

    /**
     * 节点的CSS样式
     */
    private String cls;

    /**
     * 功能描述
     */
    private String notes;

    /**
     * 所属系统类型
     */
    private String belongSystemType;
    /**
     * 权限类型集合,.
     */
    private List<String> resourceTypes;
    /**
     * 权限所属系统类型，
     */
    private List<String> systemTypes;

    @Override
    public IModule getModule() {
        return null;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getFunctionCode() {
        return null;
    }

    @Override
    public Boolean getValidFlag() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
