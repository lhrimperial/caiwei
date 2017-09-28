package com.caiwei.business.comm.mapper;

import com.caiwei.business.comm.service.api.domain.TermsCodePO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 9:49
 */
@Repository
public interface TermsCodeMapper {


    /**
     *
     * @param termsCode
     * @return
     */
    TermsCodePO findTermsCodeByCode(String termsCode);

    /**
     *
     * @param termsCodePO
     */
    void update(TermsCodePO termsCodePO);

    /**
     *
     * @param termsCodePO
     */
    void insert(TermsCodePO termsCodePO);
}
