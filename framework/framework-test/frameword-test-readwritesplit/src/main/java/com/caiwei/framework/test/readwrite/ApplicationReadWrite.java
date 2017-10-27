package com.caiwei.framework.test.readwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author longhairen
 * @create 2017/8/15 0015 下午 6:42
 * "com.lvmama.boot",
 */
@SpringBootApplication
@ComponentScan("com.caiwei")
public class ApplicationReadWrite {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationReadWrite.class, args);
    }

}
