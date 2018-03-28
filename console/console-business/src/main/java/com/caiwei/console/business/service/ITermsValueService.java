package com.caiwei.console.business.service;



import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;
import com.caiwei.console.persistent.domain.TermsValuePO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface ITermsValueService {

    List<TermsCodeDO> findTermsCodeByParam(TermsCodeDO termsCodeDO);

    List<TermsValueDO> findTermsValueByParam(TermsValueDO termsValueDO, int pageNo, int pageSize);

    long totalCount(TermsValueDO termsValueDO);

    int insertTermsCode(TermsCodeDO termsCodeDO);

    int updateTermsCode(TermsCodeDO termsCodeDO);

    int deleteTermsCode(String termsCode);

    TermsCodeDO findByCode(String termsCode);

    List<TermsCodeDO> findAllCode();

    int insertTermsValue(TermsValueDO termsValueDO);

    int updateTermsValue(TermsValueDO termsValueDO);

    int deleteTermsValue(String valueCode);

    TermsValueDO findByTermsCodeAndValueCode(String termsCode, String valueCode);

    List<TermsValueDO> findByTermsCode(String termsCode);

    int updateBatch(List<TermsValuePO> termsValueDOS);

    TermsValueDO findByID(Integer tid);

}
