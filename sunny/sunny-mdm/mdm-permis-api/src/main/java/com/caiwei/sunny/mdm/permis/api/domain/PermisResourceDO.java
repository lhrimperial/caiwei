package com.caiwei.sunny.mdm.permis.api.domain;

import java.util.Date;

public class PermisResourceDO {
    /**
    t_mdm_permis_resource*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 权限编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String resCode;

    /**
     * 权限名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String resName;

    /**
     * 权限入口URI
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String entryUrl;

    /**
     * 功能层级(1：子系统 2：模块 3：菜单 4：按钮)
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer resLevel;

    /**
     * 上级权限
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String parentRes;

    /**
     * 权限类型(1：子系统 2：模块 3：菜单 4：按钮)
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer resType;

    /**
     * 显示顺序
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer displayOrder;

    /**
     * 是否权限检查
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer checked;

    /**
     * 是否叶子节点
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer leafFlag;

    /**
     * 节点的CSS样式
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String nodeCls;

    /**
     * 图标的CSS样式
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String iconCls;

    /**
     * 所属系统类型
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String systemCode;

    /**
     * 权限描述
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String notes;

    /**
     * 逻辑删除
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_permis_resource*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_permis_resource.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.res_code
     */
    public String getResCode() {
        return resCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param resCode the value for t_mdm_permis_resource.res_code
     */
    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.res_name
     */
    public String getResName() {
        return resName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param resName the value for t_mdm_permis_resource.res_name
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.entry_url
     */
    public String getEntryUrl() {
        return entryUrl;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param entryUrl the value for t_mdm_permis_resource.entry_url
     */
    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl == null ? null : entryUrl.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.res_level
     */
    public Integer getResLevel() {
        return resLevel;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param resLevel the value for t_mdm_permis_resource.res_level
     */
    public void setResLevel(Integer resLevel) {
        this.resLevel = resLevel;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.parent_res
     */
    public String getParentRes() {
        return parentRes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param parentRes the value for t_mdm_permis_resource.parent_res
     */
    public void setParentRes(String parentRes) {
        this.parentRes = parentRes == null ? null : parentRes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.res_type
     */
    public Integer getResType() {
        return resType;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param resType the value for t_mdm_permis_resource.res_type
     */
    public void setResType(Integer resType) {
        this.resType = resType;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.display_order
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param displayOrder the value for t_mdm_permis_resource.display_order
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.checked
     */
    public Integer getChecked() {
        return checked;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param checked the value for t_mdm_permis_resource.checked
     */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.leaf_flag
     */
    public Integer getLeafFlag() {
        return leafFlag;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param leafFlag the value for t_mdm_permis_resource.leaf_flag
     */
    public void setLeafFlag(Integer leafFlag) {
        this.leafFlag = leafFlag;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.node_cls
     */
    public String getNodeCls() {
        return nodeCls;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param nodeCls the value for t_mdm_permis_resource.node_cls
     */
    public void setNodeCls(String nodeCls) {
        this.nodeCls = nodeCls == null ? null : nodeCls.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.icon_cls
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param iconCls the value for t_mdm_permis_resource.icon_cls
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.system_code
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param systemCode the value for t_mdm_permis_resource.system_code
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param notes the value for t_mdm_permis_resource.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_permis_resource.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_permis_resource.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_permis_resource.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}