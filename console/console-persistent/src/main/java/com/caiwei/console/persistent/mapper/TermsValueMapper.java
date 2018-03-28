package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.TermsValueDO;
import com.caiwei.console.persistent.domain.TermsValuePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsValueMapper {

    List<TermsValueDO> findByTermsCode(String termsCode);

    TermsValueDO findByTermsCodeAndValueCode(@Param("termsCode") String termsCode, @Param("valueCode") String valueCode);

    int insert(TermsValuePO record);

    int update(TermsValuePO record);

    int updateBatch(List<TermsValuePO> termsValueDOS);

    List<TermsValueDO> findTermsValueByParam(TermsValueDO termsValueDO);

    long totalCount(TermsValueDO termsValueDO);
}