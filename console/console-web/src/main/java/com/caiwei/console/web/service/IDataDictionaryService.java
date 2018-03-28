package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.DataDictionaryVO;

/**
 *
 */
public interface IDataDictionaryService {

    public DataDictionaryVO searchDataDictionary();

    DataDictionaryVO queryDataDictionaryByTermsCode(DataDictionaryVO dataDictionaryVO);

    DataDictionaryVO queryDataDictionaryValueByTermsValue(DataDictionaryVO dataDictionaryVO);

    void deleteDataDictionaryValue(DataDictionaryVO dataDictionaryVO);

    void addTermsCode(DataDictionaryVO dataDictionaryVO);

    void addTermsValue(DataDictionaryVO dataDictionaryVO);
}
