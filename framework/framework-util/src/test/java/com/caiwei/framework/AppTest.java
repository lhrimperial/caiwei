package com.caiwei.framework;

import org.springframework.beans.BeanUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) throws Exception{
        StringUtils.isEmpty("");
        BeanUtils.copyProperties(new Object(), new Object());
        FileCopyUtils.copy(new File(""), new File(""));
    }

}
