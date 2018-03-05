package com.caiwei.console.persistent.domain;


public class TermsCodePO extends BasePO{

    private static final long serialVersionUID = -1046503061844307480L;
    /**
     * 条款编码
     */
    private String termsCode;

    /**
     * 条款名称
     */
    private String termsName;

    private String notes;

    public String getTermsCode() {
        return termsCode;
    }

    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}