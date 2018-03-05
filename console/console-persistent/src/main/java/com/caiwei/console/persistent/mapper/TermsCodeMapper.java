package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.TermsCodePO;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsCodeMapper {

    TermsCodePO findByTermsCode(String termsCode);

    int insert(TermsCodePO record);

    int update(TermsCodePO record);
}