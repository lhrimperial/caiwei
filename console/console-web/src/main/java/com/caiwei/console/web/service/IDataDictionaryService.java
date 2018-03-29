package com.caiwei.console.web.service;

import com.caiwei.console.web.domain.DataDictionaryVO;

/**
 *
 */
public interface IDataDictionaryService {

    public DataDictionaryVO searchDataDictionary();

    DataDictionaryVO queryTermsCodeByID(DataDictionaryVO dataDictionaryVO);

    DataDictionaryVO queryTermsCodeByParam(DataDictionaryVO dataDictionaryVO);

    void deleteTermsCode(DataDictionaryVO dataDictionaryVO);

    void updateTermsCode(DataDictionaryVO dataDictionaryVO);

    DataDictionaryVO queryDataDictionaryByTermsCode(DataDictionaryVO dataDictionaryVO);

    DataDictionaryVO queryDataDictionaryValueByTermsValue(DataDictionaryVO dataDictionaryVO);

    void deleteDataDictionaryValue(DataDictionaryVO dataDictionaryVO);

    void addTermsCode(DataDictionaryVO dataDictionaryVO);

    void addTermsValue(DataDictionaryVO dataDictionaryVO);

    DataDictionaryVO findDataDictionaryById(DataDictionaryVO dataDictionaryVO);

    void updateDataDictionary(DataDictionaryVO dataDictionaryVO);

}
