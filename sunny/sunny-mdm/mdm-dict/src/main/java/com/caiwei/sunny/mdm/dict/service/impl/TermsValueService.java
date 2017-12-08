package com.caiwei.sunny.mdm.dict.service.impl;

import com.caiwei.sunny.mdm.dict.api.domain.TermsCodeDO;
import com.caiwei.sunny.mdm.dict.api.domain.TermsValueDO;
import com.caiwei.sunny.mdm.dict.api.service.ITermsValueService;
import com.caiwei.sunny.mdm.dict.mapper.TermsCodeMapper;
import com.caiwei.sunny.mdm.dict.mapper.TermsValueMapper;
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
    public int insertTermsCode(TermsCodeDO termsCodeDO) {
        return termsCodeMapper.insert(termsCodeDO);
    }

    @Override
    public int updateTermsCode(TermsCodeDO termsCodeDO) {
        return termsCodeMapper.updateByPrimaryKey(termsCodeDO);
    }

    @Override
    public int deleteTermsCode(int ttcId) {
        return termsCodeMapper.deleteByPrimaryKey(ttcId);
    }

    @Override
    public TermsCodeDO findByCode(String termsCode) {
        return termsCodeMapper.findByTermsCode(termsCode);
    }

    @Override
    public int insertTermsValue(TermsValueDO termsValueDO) {
        return termsValueMapper.insert(termsValueDO);
    }

    @Override
    public int updateTermsValue(TermsValueDO termsValueDO) {
        return termsValueMapper.updateByPrimaryKey(termsValueDO);
    }

    @Override
    public int deleteTermsValue(int ttvId) {
        return termsValueMapper.deleteByPrimaryKey(ttvId);
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
