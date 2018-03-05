package com.caiwei.console.business.service;



import com.caiwei.console.persistent.domain.TermsCodePO;
import com.caiwei.console.persistent.domain.TermsValuePO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface ITermsValueService {

    int insertTermsCode(TermsCodePO termsCodeDO);

    int updateTermsCode(TermsCodePO termsCodeDO);

    int deleteTermsCode(String termsCode);

    TermsCodePO findByCode(String termsCode);

    int insertTermsValue(TermsValuePO termsValueDO);

    int updateTermsValue(TermsValuePO termsValueDO);

    int deleteTermsValue(String valueCode);

    TermsValuePO findByTermsCodeAndValueCode(String termsCode, String valueCode);

    List<TermsValuePO> findByTermsCode(String termsCode);
}
