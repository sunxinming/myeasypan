package com.myeasypan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.myeasypan"})
@MapperScan(basePackages = {"com.easypan.mappers"})
@EnableTransactionManagement
@EnableScheduling
public class MyeasypanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyeasypanApplication.class, args);
    }

}
