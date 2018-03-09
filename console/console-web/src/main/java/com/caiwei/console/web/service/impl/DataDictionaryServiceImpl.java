package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.ITermsValueService;
import com.caiwei.console.web.domain.DataDictionaryVO;
import com.caiwei.console.web.service.IDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DataDictionaryServiceImpl implements IDataDictionaryService {


    @Autowired
    private ITermsValueService termsValueService;

    @Override
    public DataDictionaryVO searchDataDictionary() {
        DataDictionaryVO dataDictionaryVO = new DataDictionaryVO();
        dataDictionaryVO.setTermsCodeDOS(termsValueService.findAllCode());
        return dataDictionaryVO;
    }
}
