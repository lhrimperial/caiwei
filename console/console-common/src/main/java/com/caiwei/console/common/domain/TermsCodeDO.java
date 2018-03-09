package com.caiwei.console.common.domain;

import com.github.framework.server.shared.domain.BaseDO;

import java.util.List;

/**
 *
 */
public class TermsCodeDO extends BaseDO {
    private static final long serialVersionUID = 7179695325475517205L;

    /**
     * 条款编码
     */
    private String termsCode;

    /**
     * 条款名称
     */
    private String termsName;

    /**
     *  备注
     */
    private String notes;

    private List<TermsValueDO> termsValueDOS;

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

    public List<TermsValueDO> getTermsValueDOS() {
        return termsValueDOS;
    }

    public void setTermsValueDOS(List<TermsValueDO> termsValueDOS) {
        this.termsValueDOS = termsValueDOS;
    }
}
