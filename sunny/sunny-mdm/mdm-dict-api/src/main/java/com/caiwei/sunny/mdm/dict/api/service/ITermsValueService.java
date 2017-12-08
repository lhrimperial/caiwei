package com.caiwei.sunny.mdm.dict.api.service;


import com.caiwei.sunny.mdm.dict.api.domain.TermsCodeDO;
import com.caiwei.sunny.mdm.dict.api.domain.TermsValueDO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface ITermsValueService {

    int insertTermsCode(TermsCodeDO termsCodeDO);

    int updateTermsCode(TermsCodeDO termsCodeDO);

    int deleteTermsCode(int ttcId);

    TermsCodeDO findByCode(String termsCode);

    int insertTermsValue(TermsValueDO termsValueDO);

    int updateTermsValue(TermsValueDO termsValueDO);

    int deleteTermsValue(int ttvId);

    TermsValueDO findByTermsCodeAndValueCode(String termsCode, String valueCode);

    List<TermsValueDO> findByTermsCode(String termsCode);
}
