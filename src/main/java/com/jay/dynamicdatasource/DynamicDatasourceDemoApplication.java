package com.jay.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jay.dynamicdatasource.mapper")
public class DynamicDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceDemoApplication.class, args);
    }

}
