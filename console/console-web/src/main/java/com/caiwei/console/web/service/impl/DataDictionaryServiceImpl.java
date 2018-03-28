package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.ITermsValueService;
import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;
import com.caiwei.console.persistent.domain.TermsValuePO;
import com.caiwei.console.web.domain.DataDictionaryVO;
import com.caiwei.console.web.service.IDataDictionaryService;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.define.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public DataDictionaryVO queryDataDictionaryByTermsCode(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        List<TermsCodeDO> termsCodeDOS = termsValueService.findTermsCodeByParam(dataDictionaryVO.getTermsCodeDO());
        dataDictionaryVO.setTermsCodeDOS(termsCodeDOS);
        return dataDictionaryVO;
    }

    @Override
    public DataDictionaryVO queryDataDictionaryValueByTermsValue(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        List<TermsValueDO> termsValueDOS = termsValueService.findTermsValueByParam(dataDictionaryVO.getTermsValueDO(), dataDictionaryVO.getPage(), dataDictionaryVO.getLimit());
        dataDictionaryVO.setTermsValueDOS(termsValueDOS);
        dataDictionaryVO.setTotalCount(termsValueService.totalCount(dataDictionaryVO.getTermsValueDO()));
        return dataDictionaryVO;
    }

    @Override
    public void deleteDataDictionaryValue(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        List<TermsValueDO> list =  dataDictionaryVO.getTermsValueDOS();
        if (list != null && list.size() > 0) {
            List<TermsValuePO> termsValuePOS = new ArrayList<>(list.size());
            for (TermsValueDO valueDO : list) {
                termsValuePOS.add(new TermsValuePO(valueDO.getValueCode(), valueDO.getTermsCode(), Constants.PO_INACTIVE));
            }
            termsValueService.updateBatch(termsValuePOS);
        }

    }

    @Override
    public void addTermsCode(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        TermsCodeDO termsCodeDO = dataDictionaryVO.getTermsCodeDO();
        termsValueService.insertTermsCode(termsCodeDO);
    }

    @Override
    public void addTermsValue(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        TermsValueDO termsValueDO = dataDictionaryVO.getTermsValueDO();
        termsValueService.insertTermsValue(termsValueDO);
    }

    @Override
    public DataDictionaryVO findDataDictionaryById(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null || dataDictionaryVO.getTermsValueDO() == null) {
            throw new BusinessException("请求参数为空！");
        }
        TermsValueDO termsValueDO = termsValueService.findByID(dataDictionaryVO.getTermsValueDO().getTid());
        dataDictionaryVO.setTermsValueDO(termsValueDO);
        return dataDictionaryVO;
    }


    @Override
    public void updateDataDictionary(DataDictionaryVO dataDictionaryVO) {
        if (dataDictionaryVO == null) {
            throw new BusinessException("请求参数为空！");
        }
        TermsValueDO termsValueDO = dataDictionaryVO.getTermsValueDO();
        termsValueService.updateTermsValue(termsValueDO);
    }
}
