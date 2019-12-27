package com.quanxian.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  he a;fdkfjal;dsk f
@SpringBootApplication
@MapperScan("com.quanxian.demo.mapper")
public class QuanxianApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanxianApplication.class, args);
    }

}
