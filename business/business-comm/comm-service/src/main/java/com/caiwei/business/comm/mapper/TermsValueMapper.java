package com.caiwei.business.comm.mapper;

import com.caiwei.business.comm.service.api.domain.TermsValuePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 9:55
 */
@Repository
public interface TermsValueMapper {

    /**
     *
     * @param termsCode
     * @return
     */
    List<TermsValuePO> findTermsValues(String termsCode);

    /**
     *
     * @param termsCode
     * @param valueCode
     * @return
     */
    TermsValuePO findTermsValueByCode(@Param("termsCode") String termsCode, @Param("valueCode") String valueCode);

    /**
     *
     * @param termsValuePO
     */
    void update(TermsValuePO termsValuePO);
    /**
     *
     * @param termsValuePO
     */
    void insert(TermsValuePO termsValuePO);
}
