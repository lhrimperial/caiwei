package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.ITermsValueService;
import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.common.domain.TermsValueDO;
import com.caiwei.console.common.util.ConvertUtil;
import com.caiwei.console.persistent.domain.TermsCodePO;
import com.caiwei.console.persistent.domain.TermsValuePO;
import com.caiwei.console.persistent.mapper.TermsCodeMapper;
import com.caiwei.console.persistent.mapper.TermsValueMapper;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<TermsCodeDO> findTermsCodeByParam(TermsCodeDO termsCodeDO) {
        if (termsCodeDO != null && StringUtils.isNotBlank(termsCodeDO.getActive())) {
            termsCodeDO.setStatus(ConvertUtil.activeToStatus(termsCodeDO.getActive()));
        }
        return termsCodeMapper.findTermsCodeByParam(termsCodeDO);
    }

    @Override
    public List<TermsValueDO> findTermsValueByParam(TermsValueDO termsValueDO, int pageNo, int pageSize) {
        if (termsValueDO != null && StringUtils.isNotBlank(termsValueDO.getActive())) {
            termsValueDO.setStatus(ConvertUtil.activeToStatus(termsValueDO.getActive()));
        }
        PageHelper.startPage(pageNo, pageSize);
        return termsValueMapper.findTermsValueByParam(termsValueDO);
    }

    @Override
    public long totalCount(TermsValueDO termsValueDO) {
        return termsValueMapper.totalCount(termsValueDO);
    }

    @Override
    public int insertTermsCode(TermsCodeDO termsCodeDO) {
        TermsCodePO termsCodePO = new TermsCodePO();
        BeanCopyUtils.copyBean(termsCodeDO, termsCodePO);
        if (termsCodePO.getCreateTime() == null) {
            termsCodePO.setCreateTime(new Date());
            termsCodePO.setModifyTime(new Date());
        }
        termsCodePO.setStatus(Constants.PO_ACTIVE);
        return termsCodeMapper.insert(termsCodePO);
    }

    @Override
    public int updateTermsCode(TermsCodeDO termsCodeDO) {
        TermsCodePO termsCodePO = new TermsCodePO();
        BeanCopyUtils.copyBean(termsCodeDO, termsCodePO);
        if (termsCodePO.getCreateTime() == null) {
            termsCodePO.setModifyTime(new Date());
        }
        return termsCodeMapper.update(termsCodePO);
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
    public int insertTermsValue(TermsValueDO termsValueDO) {
        TermsValuePO termsValuePO = new TermsValuePO();
        BeanCopyUtils.copyBean(termsValueDO, termsValuePO);
        termsValuePO.setStatus(Constants.PO_ACTIVE);
        termsValuePO.setCreateTime(new Date());
        termsValuePO.setModifyTime(new Date());
        return termsValueMapper.insert(termsValuePO);
    }

    @Override
    public int updateTermsValue(TermsValueDO termsValueDO) {
        TermsValuePO termsValuePO = new TermsValuePO();
        BeanCopyUtils.copyBean(termsValueDO, termsValuePO);
        termsValuePO.setModifyTime(new Date());
        termsValuePO.setStatus(StringUtils.isBlank(termsValueDO.getActive())?null:ConvertUtil.activeToStatus(termsValueDO.getActive()));
        return termsValueMapper.update(termsValuePO);
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

    @Override
    public int updateBatch(List<TermsValuePO> termsValueDOS) {
        int count = 0;
        for (TermsValuePO po : termsValueDOS) {
            count+=termsValueMapper.update(po);
        }
        return count;
    }

    @Override
    public TermsValueDO findByID(Integer tid) {
        return termsValueMapper.findByID(tid);
    }
}
