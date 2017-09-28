package com.caiwei.business.comm.service.api.domain;

import java.util.Date;

public class TermsValuePO {
    /**
     t_base_data_termsvalue*id
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Integer id;

    /**
     * 值编码
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String valueCode;

    /**
     * 值名称
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String valueName;

    /**
     * 条款编码
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String termsCode;

    /**
     * 排序
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Integer valueSeq;

    /**
     t_base_data_termsvalue*notes
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String notes;

    /**
     t_base_data_termsvalue*version_no
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Long versionNo;

    /**
     t_base_data_termsvalue*is_delete
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Integer isDelete;

    /**
     t_base_data_termsvalue*create_user
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String createUser;

    /**
     t_base_data_termsvalue*create_time
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Date createTime;

    /**
     t_base_data_termsvalue*modify_user
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private String modifyUser;

    /**
     t_base_data_termsvalue*modify_time
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     */
    private Date modifyTime;

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param id the value for t_base_data_termsvalue.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.value_code
     */
    public String getValueCode() {
        return valueCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param valueCode the value for t_base_data_termsvalue.value_code
     */
    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.value_name
     */
    public String getValueName() {
        return valueName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param valueName the value for t_base_data_termsvalue.value_name
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.terms_code
     */
    public String getTermsCode() {
        return termsCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param termsCode the value for t_base_data_termsvalue.terms_code
     */
    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode == null ? null : termsCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.value_seq
     */
    public Integer getValueSeq() {
        return valueSeq;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param valueSeq the value for t_base_data_termsvalue.value_seq
     */
    public void setValueSeq(Integer valueSeq) {
        this.valueSeq = valueSeq;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param notes the value for t_base_data_termsvalue.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.version_no
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param versionNo the value for t_base_data_termsvalue.version_no
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param isDelete the value for t_base_data_termsvalue.is_delete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param createUser the value for t_base_data_termsvalue.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param createTime the value for t_base_data_termsvalue.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param modifyUser the value for t_base_data_termsvalue.modify_user
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @return the value of t_base_data_termsvalue.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-06-14 09:46:37
     * @param modifyTime the value for t_base_data_termsvalue.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}