package com.caiwei.business.comm.service.api.domain;

import java.util.Date;

public class TermsCodePO {
    /**
     t_base_data_termscode*id
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private Integer id;

    /**
     * 条款编码
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private String termsCode;

    /**
     * 条款名称
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private String termsName;

    /**
     t_base_data_termscode*notes
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private String notes;

    /**
     t_base_data_termscode*version_no
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private Long versionNo;

    /**
     t_base_data_termscode*is_delete
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private Integer isDelete;

    /**
     t_base_data_termscode*create_user
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private String createUser;

    /**
     t_base_data_termscode*create_time
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private Date createTime;

    /**
     t_base_data_termscode*modify_user
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private String modifyUser;

    /**
     t_base_data_termscode*modify_time
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param id the value for t_base_data_termscode.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.terms_code
     */
    public String getTermsCode() {
        return termsCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param termsCode the value for t_base_data_termscode.terms_code
     */
    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode == null ? null : termsCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.terms_name
     */
    public String getTermsName() {
        return termsName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param termsName the value for t_base_data_termscode.terms_name
     */
    public void setTermsName(String termsName) {
        this.termsName = termsName == null ? null : termsName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param notes the value for t_base_data_termscode.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param versionNo the value for t_base_data_termscode.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param isDelete the value for t_base_data_termscode.is_delete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param createUser the value for t_base_data_termscode.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param createTime the value for t_base_data_termscode.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param modifyUser the value for t_base_data_termscode.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @return the value of t_base_data_termscode.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:06
     * @param modifyTime the value for t_base_data_termscode.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}