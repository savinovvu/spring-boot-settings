package ru.inbox.savinov_vu.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@MapperScan("ru.inbox.savinov_vu.mappers")
public class MyBatisApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }
}
