package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class DataDictionaryVO implements Serializable{


    private static final long serialVersionUID = 6663183729008187040L;

    private Long clientVersionNo;

    private TermsCodeDO termsCodeDO;

    private TermsValueDO termsValueDO;

    private List<TermsCodeDO> termsCodeDOS;

    private List<TermsValueDO> termsValueDOS;

    public Long getClientVersionNo() {
        return clientVersionNo;
    }

    public void setClientVersionNo(Long clientVersionNo) {
        this.clientVersionNo = clientVersionNo;
    }

    public TermsCodeDO getTermsCodeDO() {
        return termsCodeDO;
    }

    public void setTermsCodeDO(TermsCodeDO termsCodeDO) {
        this.termsCodeDO = termsCodeDO;
    }

    public TermsValueDO getTermsValueDO() {
        return termsValueDO;
    }

    public void setTermsValueDO(TermsValueDO termsValueDO) {
        this.termsValueDO = termsValueDO;
    }

    public List<TermsCodeDO> getTermsCodeDOS() {
        return termsCodeDOS;
    }

    public void setTermsCodeDOS(List<TermsCodeDO> termsCodeDOS) {
        this.termsCodeDOS = termsCodeDOS;
    }

    public List<TermsValueDO> getTermsValueDOS() {
        return termsValueDOS;
    }

    public void setTermsValueDOS(List<TermsValueDO> termsValueDOS) {
        this.termsValueDOS = termsValueDOS;
    }
}
