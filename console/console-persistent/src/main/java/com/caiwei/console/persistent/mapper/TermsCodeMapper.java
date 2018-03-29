package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.persistent.domain.TermsCodePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsCodeMapper {

    TermsCodeDO findByTermsCode(String termsCode);

    int insert(TermsCodePO record);

    int update(TermsCodePO record);

    List<TermsCodeDO> findAllCode();

    List<TermsCodeDO> findTermsCodeByParam(TermsCodeDO termsCodeDO);

    int batchUpdateTermsCodeStatus(@Param("termsCodes") List<String> termsCodes, @Param("status") Byte status);

    TermsCodeDO queryTermsCodeByID(Integer tid);

    long termsCodeTotalCount(TermsCodeDO termsCodeDO);
}