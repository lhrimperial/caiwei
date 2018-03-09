package com.caiwei.console.business.service;



import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;
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

    TermsCodeDO findByCode(String termsCode);

    List<TermsCodeDO> findAllCode();

    int insertTermsValue(TermsValuePO termsValueDO);

    int updateTermsValue(TermsValuePO termsValueDO);

    int deleteTermsValue(String valueCode);

    TermsValueDO findByTermsCodeAndValueCode(String termsCode, String valueCode);

    List<TermsValueDO> findByTermsCode(String termsCode);
}
