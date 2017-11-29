package com.caiwei.sunny.mdm.dict.api.domain;

import java.util.Date;

public class TermsValueDO {
    /**
    t_mdm_data_termsvalue*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 值编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String valueCode;

    /**
     * 值名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String valueName;

    /**
     * 条款编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String termsCode;

    /**
     * 排序
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer valueSeq;

    /**
    t_mdm_data_termsvalue*notes
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String notes;

    /**
    t_mdm_data_termsvalue*status
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_data_termsvalue*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_data_termsvalue.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.value_code
     */
    public String getValueCode() {
        return valueCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param valueCode the value for t_mdm_data_termsvalue.value_code
     */
    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.value_name
     */
    public String getValueName() {
        return valueName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param valueName the value for t_mdm_data_termsvalue.value_name
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.terms_code
     */
    public String getTermsCode() {
        return termsCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param termsCode the value for t_mdm_data_termsvalue.terms_code
     */
    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode == null ? null : termsCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.value_seq
     */
    public Integer getValueSeq() {
        return valueSeq;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param valueSeq the value for t_mdm_data_termsvalue.value_seq
     */
    public void setValueSeq(Integer valueSeq) {
        this.valueSeq = valueSeq;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param notes the value for t_mdm_data_termsvalue.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_data_termsvalue.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termsvalue.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_data_termsvalue.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}