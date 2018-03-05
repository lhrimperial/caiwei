package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.ITermsValueService;
import com.caiwei.console.persistent.domain.TermsCodePO;
import com.caiwei.console.persistent.domain.TermsValuePO;
import com.caiwei.console.persistent.mapper.TermsCodeMapper;
import com.caiwei.console.persistent.mapper.TermsValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class TermsValueService implements ITermsValueService {

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
        return termsCodeMapper.updateByPrimaryKey(termsCodeDO);
    }

    @Override
    public int deleteTermsCode(int ttcId) {
        return termsCodeMapper.deleteByPrimaryKey(ttcId);
    }

    @Override
    public TermsCodePO findByCode(String termsCode) {
        return termsCodeMapper.findByTermsCode(termsCode);
    }

    @Override
    public int insertTermsValue(TermsValuePO termsValueDO) {
        return termsValueMapper.insert(termsValueDO);
    }

    @Override
    public int updateTermsValue(TermsValuePO termsValueDO) {
        return termsValueMapper.updateByPrimaryKey(termsValueDO);
    }

    @Override
    public int deleteTermsValue(int ttvId) {
        return termsValueMapper.deleteByPrimaryKey(ttvId);
    }

    @Override
    public TermsValuePO findByTermsCodeAndValueCode(String termsCode, String valueCode) {
        return termsValueMapper.findByTermsCodeAndValueCode(termsCode, valueCode);
    }

    @Override
    public List<TermsValuePO> findByTermsCode(String termsCode) {
        return termsValueMapper.findByTermsCode(termsCode);
    }
}
