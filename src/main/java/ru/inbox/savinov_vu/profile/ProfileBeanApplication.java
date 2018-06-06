package ru.inbox.savinov_vu.profile;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.inbox.savinov_vu.utils.HelloSayer;

import javax.annotation.Resource;



@SpringBootApplication
public class ProfileBeanApplication implements CommandLineRunner {

    @Resource
    HelloSayer helloSayer;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(ProfileBeanApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("================================");
        System.out.println(helloSayer.toString());
    }


//  -Dspring.profiles.active=DEV
    @Bean
    @Profile("DEV")
    public HelloSayer devProfile() {
        return new HelloSayer("develop");
    }

//  -Dspring.profiles.active=PROD
    @Bean
    @Profile("PROD")
    public HelloSayer prodProfile() {
        return new HelloSayer("production");
    }


//  default without params
    @Bean
    @Profile("default")
    public HelloSayer defaultProfile() {
        return new HelloSayer("default");
    }





}
