package ru.inbox.savinov_vu.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LoggingApplication implements CommandLineRunner{

    Logger logger = LoggerFactory.getLogger(LoggingApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LoggingApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) {
        System.out.println("+++++++++++++++++++=");
        logger.debug("====================this is debug log==================");
        logger.info("====================this is info log==================");
        logger.error("====================this is error log==================");
        logger.warn("====================this is warn log==================");
    }
}
