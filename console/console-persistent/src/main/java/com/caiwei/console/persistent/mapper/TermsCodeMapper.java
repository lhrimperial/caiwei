package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.persistent.domain.TermsCodePO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsCodeMapper {

    TermsCodeDO findByTermsCode(String termsCode);

    int insert(TermsCodePO record);

    int update(TermsCodePO record);

    List<TermsCodeDO> findAllCode();
}