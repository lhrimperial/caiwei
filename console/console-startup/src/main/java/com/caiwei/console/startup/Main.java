package com.caiwei.console.startup;

import com.caiwei.starter.core.ApplicationContexts;
import com.caiwei.starter.core.FrameBootApplication;
import org.springframework.boot.SpringApplication;

/**
 *
 */
@FrameBootApplication(appName = "console")
public class Main {

    public static void main(String[] args){
        ApplicationContexts.setProfileIfNotExists("dev");
        SpringApplication.run(Main.class);
    }
}
