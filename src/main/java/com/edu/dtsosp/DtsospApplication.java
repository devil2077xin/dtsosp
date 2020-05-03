package com.edu.dtsosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.edu.dtsosp.mapper")
@SpringBootApplication()
public class DtsospApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtsospApplication.class, args);
    }

}
