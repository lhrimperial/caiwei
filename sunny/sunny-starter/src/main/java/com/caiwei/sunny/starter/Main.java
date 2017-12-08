package com.caiwei.sunny.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@SpringBootApplication
@ComponentScan("com.caiwei")
@ServletComponentScan
public class Main {

    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Main.class);

        application.run(args);
    }

}
