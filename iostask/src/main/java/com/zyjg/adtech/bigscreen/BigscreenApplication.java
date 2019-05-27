package com.zyjg.adtech.bigscreen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@MapperScan("com.zyjg.adtech.bigscreen.mapper")
public class BigscreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigscreenApplication.class, args);
    }

}
