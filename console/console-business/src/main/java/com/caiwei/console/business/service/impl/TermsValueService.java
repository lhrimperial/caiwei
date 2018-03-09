package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.ITermsValueService;
import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;
import com.caiwei.console.persistent.domain.TermsCodePO;
import com.caiwei.console.persistent.domain.TermsValuePO;
import com.caiwei.console.persistent.mapper.TermsCodeMapper;
import com.caiwei.console.persistent.mapper.TermsValueMapper;
import com.github.framework.server.shared.define.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class TermsValueService implements ITermsValueService {

    public static final String CACHE_NAME = TermsValueService.class.getName();

    @Autowired
    private TermsCodeMapper termsCodeMapper;

    @Autowired
    private TermsValueMapper termsValueMapper;

    @Override
    public int insertTermsCode(TermsCodePO termsCodeDO) {
        return termsCodeMapper.insert(termsCodeDO);
    }

    @Override
    public int updateTermsCode(TermsCodePO termsCodeDO) {
        return termsCodeMapper.update(termsCodeDO);
    }

    @Override
    public int deleteTermsCode(String termsCode) {
        TermsCodePO termsCodeDO = new TermsCodePO(termsCode, Constants.PoStatus.INACTIVE.value());
        return termsCodeMapper.update(termsCodeDO);
    }

    @Override
    public TermsCodeDO findByCode(String termsCode) {
        return termsCodeMapper.findByTermsCode(termsCode);
    }

    @Override
    @Cacheable(cacheNames = "com.caiwei.console.business.service.impl.TermsValueService.findAllCode")
    public List<TermsCodeDO> findAllCode() {
        return termsCodeMapper.findAllCode();
    }


    @Override
    public int insertTermsValue(TermsValuePO termsValueDO) {
        return termsValueMapper.insert(termsValueDO);
    }

    @Override
    public int updateTermsValue(TermsValuePO termsValueDO) {
        return termsValueMapper.update(termsValueDO);
    }

    @Override
    public int deleteTermsValue(String termsValueCode) {
        TermsValuePO termsValuePO = new TermsValuePO(termsValueCode, Constants.PoStatus.INACTIVE.value());
        return termsValueMapper.update(termsValuePO);
    }

    @Override
    public TermsValueDO findByTermsCodeAndValueCode(String termsCode, String valueCode) {
        return termsValueMapper.findByTermsCodeAndValueCode(termsCode, valueCode);
    }

    @Override
    public List<TermsValueDO> findByTermsCode(String termsCode) {
        return termsValueMapper.findByTermsCode(termsCode);
    }
}
