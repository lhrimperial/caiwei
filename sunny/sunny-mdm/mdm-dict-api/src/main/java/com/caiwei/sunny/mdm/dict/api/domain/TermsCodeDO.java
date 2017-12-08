package com.caiwei.sunny.mdm.dict.api.domain;

import java.util.Date;

public class TermsCodeDO {
    /**
    t_mdm_data_termscode*id
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer id;

    /**
     * 条款编码
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String termsCode;

    /**
     * 条款名称
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String termsName;

    /**
    t_mdm_data_termscode*notes
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private String notes;

    /**
    t_mdm_data_termscode*status
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Integer status;

    /**
    t_mdm_data_termscode*create_time
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     */
    private Date createTime;

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param id the value for t_mdm_data_termscode.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.terms_code
     */
    public String getTermsCode() {
        return termsCode;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param termsCode the value for t_mdm_data_termscode.terms_code
     */
    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode == null ? null : termsCode.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.terms_name
     */
    public String getTermsName() {
        return termsName;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param termsName the value for t_mdm_data_termscode.terms_name
     */
    public void setTermsName(String termsName) {
        this.termsName = termsName == null ? null : termsName.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param notes the value for t_mdm_data_termscode.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param status the value for t_mdm_data_termscode.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @return the value of t_mdm_data_termscode.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @author Administrator
     * @date 2017-11-06 16:41:43
     * @param createTime the value for t_mdm_data_termscode.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}