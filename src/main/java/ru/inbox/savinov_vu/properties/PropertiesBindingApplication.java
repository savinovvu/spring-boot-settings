package ru.inbox.savinov_vu.properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;



@SpringBootApplication
public class PropertiesBindingApplication implements CommandLineRunner {

    @Resource
    MyProperties properties;


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(PropertiesBindingApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("============propeties binding=========");
        System.out.println(properties.toString());
    }


}
