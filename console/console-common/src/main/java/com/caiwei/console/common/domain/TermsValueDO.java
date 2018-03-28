package com.caiwei.console.common.domain;

import com.github.framework.server.shared.domain.BaseDO;

/**
 *
 */
public class TermsValueDO extends BaseDO {
    private static final long serialVersionUID = -24170148691659237L;

    /**
     * 值编码
     */
    private String valueCode;

    /**
     * 值名称
     */
    private String valueName;

    /**
     * 条款编码
     */
    private String termsCode;

    /**
     * 词条名称
     */
    private String termsName;

    /**
     * 排序
     */
    private Byte valueSeq;

    private String notes;

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getTermsCode() {
        return termsCode;
    }

    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode;
    }

    public Byte getValueSeq() {
        return valueSeq;
    }

    public void setValueSeq(Byte valueSeq) {
        this.valueSeq = valueSeq;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
