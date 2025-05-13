package com.wdd.studentManager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.wdd.studentManager.mapper")
@SpringBootApplication
@Slf4j
@EnableCaching
@EnableScheduling
public class StudentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }

}
