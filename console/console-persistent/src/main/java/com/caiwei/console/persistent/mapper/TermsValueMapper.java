package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.TermsValuePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsValueMapper {

    List<TermsValuePO> findByTermsCode(String termsCode);

    TermsValuePO findByTermsCodeAndValueCode(@Param("termsCode") String termsCode, @Param("valueCode") String valueCode);

    int insert(TermsValuePO record);

    int update(TermsValuePO record);
}