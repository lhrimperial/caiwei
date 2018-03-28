package com.caiwei.console.common.domain;

import com.caiwei.console.common.define.ConsoleConstants;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.server.shared.domain.BaseDO;
import com.github.framework.util.string.StringUtils;

/**
 *
 */
public class ResourceDO extends BaseDO {
    private static final long serialVersionUID = -940507189055384976L;

    /**
     * 权限编码
     */
    private String resCode;

    /**
     * 权限名称
     */
    private String resName;

    /**
     * 权限入口URI
     */
    private String entryUrl;

    /**
     * 功能层级(1：子系统 2：模块 3：菜单 4：按钮)
     */
    private Byte resLevel;

    /**
     * 上级权限
     */
    private String parentRes;
    private ResourceDO parentDO;

    /**
     * 权限类型(1：子系统 2：模块 3：菜单 4：按钮)
     */
    private Byte resType;

    /**
     * 显示顺序
     */
    private Byte displayOrder;

    /**
     * 是否权限检查
     */
    private Byte checked;

    /**
     * 是否叶子节点
     */
    private Byte leafFlag;

    /**
     * 节点的CSS样式
     */
    private String nodeCls;

    /**
     * 图标的CSS样式
     */
    private String iconCls;

    /**
     * 所属系统类型
     */
    private String systemCode;

    /**
     * 权限描述
     */
    private String notes;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getEntryUrl() {
        return entryUrl;
    }

    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl;
    }

    public Byte getResLevel() {
        return resLevel;
    }

    public void setResLevel(Byte resLevel) {
        this.resLevel = resLevel;
    }

    public String getParentRes() {
        return parentRes;
    }

    public void setParentRes(String parentRes) {
        this.parentRes = parentRes;
    }

    public ResourceDO getParentDO() {
        return parentDO;
    }

    public void setParentDO(ResourceDO parentDO) {
        this.parentDO = parentDO;
    }

    public Byte getResType() {
        return resType;
    }

    public void setResType(Byte resType) {
        this.resType = resType;
    }

    public Byte getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Byte displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Byte getChecked() {
        return checked;
    }

    public void setChecked(Byte checked) {
        this.checked = checked;
    }

    public Byte getLeafFlag() {
        return leafFlag;
    }

    public void setLeafFlag(Byte leafFlag) {
        this.leafFlag = leafFlag;
    }

    public String getNodeCls() {
        return nodeCls;
    }

    public void setNodeCls(String nodeCls) {
        this.nodeCls = nodeCls;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static ResourceNode convert(ResourceDO resourceDO) {
        if (resourceDO == null) {
            return null;
        }
        ResourceNode resourceNode = new ResourceNode();
        resourceNode.setId(resourceDO.getTid()==null?"":String.valueOf(resourceDO.getTid()));
        resourceNode.setCode(resourceDO.getResCode());
        resourceNode.setName(resourceDO.getResName());
        resourceNode.setEntryUri(resourceDO.getEntryUrl());
        resourceNode.setResLevel(String.valueOf(resourceDO.getResLevel()));
        resourceNode.setParentNode(ResourceDO.convert(resourceDO.getParentDO()));
        resourceNode.setParentRes(resourceDO.getParentRes());
        resourceNode.setActive(Constants.PO_ACTIVE == resourceDO.getStatus() ? ConsoleConstants.YES : ConsoleConstants.NO);
        resourceNode.setDisplayOrder(String.valueOf(resourceDO.getDisplayOrder()));
        resourceNode.setChecked(Constants.YES == resourceDO.getChecked() ? ConsoleConstants.YES : ConsoleConstants.NO);
        resourceNode.setResType(String.valueOf(resourceDO.getResType()));
        resourceNode.setLeafFlag(Constants.YES == resourceDO.getLeafFlag() ? ConsoleConstants.YES : ConsoleConstants.NO);
        resourceNode.setIconCls(resourceDO.iconCls);
        resourceNode.setCls(resourceDO.getNodeCls());
        resourceNode.setNotes(resourceDO.getNotes());
        resourceNode.setBelongSystemType(resourceDO.getSystemCode());

        return resourceNode;
    }

    public static ResourceDO flipConvert(ResourceNode resourceNode) {
        if (resourceNode == null) {
            return null;
        }
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setTid(StringUtils.isEmpty(resourceNode.getId())?null:Integer.valueOf(resourceNode.getId()));
        resourceDO.setResCode(resourceNode.getCode());
        resourceDO.setResName(resourceNode.getName());
        resourceDO.setEntryUrl(resourceNode.getEntryUri());
        resourceDO.setResLevel(StringUtils.isEmpty(resourceNode.getResLevel())?null:Byte.valueOf(resourceNode.getResLevel()));
        resourceDO.setStatus(resourceNode.getActive()==null?null:ConsoleConstants.YES.equals(resourceNode.getActive()) ? Constants.PO_ACTIVE : Constants.PO_INACTIVE);
        resourceDO.setDisplayOrder(StringUtils.isEmpty(resourceNode.getDisplayOrder())?null:Byte.valueOf(resourceNode.getDisplayOrder()));
        resourceDO.setChecked(resourceNode.getChecked()==null?null:ConsoleConstants.YES.equals(resourceNode.getChecked()) ? Constants.YES : Constants.NO);
        resourceDO.setResType(StringUtils.isEmpty(resourceNode.getResType())?null:Byte.valueOf(resourceNode.getResType()));
        resourceDO.setLeafFlag(resourceNode.getLeafFlag()==null?null:ConsoleConstants.YES.equals(resourceNode.getLeafFlag()) ? Constants.YES : Constants.NO);
        resourceDO.setIconCls(resourceNode.getIconCls());
        resourceDO.setNodeCls(resourceNode.getCls());
        resourceDO.setNotes(resourceNode.getNotes());
        resourceDO.setSystemCode(resourceNode.getBelongSystemType());
        resourceDO.setParentDO(ResourceDO.flipConvert(resourceNode.getParentNode()));
        resourceDO.setParentRes(resourceNode.getParentRes());

        return resourceDO;
    }
}
