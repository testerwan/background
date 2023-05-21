package com.felix.background;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.felix.background.mapper")
public class AutoPlatFormApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoPlatFormApplication.class, args);
    }

}
