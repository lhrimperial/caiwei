package com.caiwei.console.test;

import com.caiwei.console.common.domain.TermsCodeDO;
import com.caiwei.console.persistent.mapper.TermsCodeMapper;
import com.github.framework.util.json.FastJsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 */
public class PersistentTest extends AbstractTest {

    @Autowired
    private TermsCodeMapper termsCodeMapper;

    @Test
    public void test() {
        List<TermsCodeDO> list = termsCodeMapper.findAllCode();
        System.out.println(FastJsonUtil.toJsonString(list));
    }
}
