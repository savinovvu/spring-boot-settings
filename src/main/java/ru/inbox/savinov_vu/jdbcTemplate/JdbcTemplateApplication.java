package ru.inbox.savinov_vu.jdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class JdbcTemplateApplication {

    Logger logger = LoggerFactory.getLogger(JdbcTemplateApplication.class.getName());


    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }
}
