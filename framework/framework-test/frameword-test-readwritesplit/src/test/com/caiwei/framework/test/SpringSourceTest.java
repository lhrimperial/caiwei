package com.caiwei.framework.test;

import com.caiwei.framework.starter.configuration.MybatisConfProperties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author longhairen
 * @create 2017/10/26 0026 上午 9:21
 */
public class SpringSourceTest {
    public static void main(String[] args){
        BeanFactory factory = new FileSystemXmlApplicationContext("");
        factory.getBean(MybatisConfProperties.class);
    }
}
