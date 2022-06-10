package com.ahut.cones;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan("com.ahut.cones")
public class ConesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConesApplication.class, args);

    }

}


