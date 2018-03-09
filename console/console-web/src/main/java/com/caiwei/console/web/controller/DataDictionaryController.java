package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.DataDictionaryVO;
import com.caiwei.console.web.service.IDataDictionaryService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class DataDictionaryController extends AbstractController{

    @Autowired
    private IDataDictionaryService dataDictionaryService;


    @RequestMapping("/searchAllDataDictionary")
    public ResponseVO<DataDictionaryVO> searchAllDataDictionary() {
        ResponseVO responseVO = returnSuccess();
        DataDictionaryVO dataDictionaryVO = dataDictionaryService.searchDataDictionary();
        responseVO.setResult(dataDictionaryVO);
        return responseVO;
    }

    @RequestMapping("/hasDictionaryChanged")
    public ResponseVO<Boolean> hasDictionaryChanged(Long clientVersionNo) {
        ResponseVO responseVO = returnSuccess();
        //TODO
        responseVO.setResult(true);
        return responseVO;
    }
}
