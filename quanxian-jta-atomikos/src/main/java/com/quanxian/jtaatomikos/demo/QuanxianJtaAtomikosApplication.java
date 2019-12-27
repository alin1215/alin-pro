package com.quanxian.jtaatomikos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.quanxian.demo.mapper")
//@ImportResource(locations = {"classpath*:spider-*"})

public class QuanxianJtaAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanxianJtaAtomikosApplication.class, args);
    }

}
