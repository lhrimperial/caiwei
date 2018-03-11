package com.caiwei.console.common.domain;

import com.github.framework.server.shared.entity.BaseEntity;
import com.github.framework.server.shared.entity.IFunction;
import com.github.framework.server.shared.entity.IModule;

import java.util.List;

/**
 * 权限业务实体
 */
public class ResourceNode extends BaseEntity implements IFunction {

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
    private ResourceNode parentResDO;

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
        return entryUri;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getFunctionCode() {
        return this.code;
    }

    @Override
    public Boolean getValidFlag() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryUri() {
        return entryUri;
    }

    public void setEntryUri(String entryUri) {
        this.entryUri = entryUri;
    }

    public String getResLevel() {
        return resLevel;
    }

    public void setResLevel(String resLevel) {
        this.resLevel = resLevel;
    }

    public ResourceNode getParentResDO() {
        return parentResDO;
    }

    public void setParentResDO(ResourceNode parentResDO) {
        this.parentResDO = parentResDO;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getLeafFlag() {
        return leafFlag;
    }

    public void setLeafFlag(String leafFlag) {
        this.leafFlag = leafFlag;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBelongSystemType() {
        return belongSystemType;
    }

    public void setBelongSystemType(String belongSystemType) {
        this.belongSystemType = belongSystemType;
    }

    public List<String> getResourceTypes() {
        return resourceTypes;
    }

    public void setResourceTypes(List<String> resourceTypes) {
        this.resourceTypes = resourceTypes;
    }

    public List<String> getSystemTypes() {
        return systemTypes;
    }

    public void setSystemTypes(List<String> systemTypes) {
        this.systemTypes = systemTypes;
    }


}
