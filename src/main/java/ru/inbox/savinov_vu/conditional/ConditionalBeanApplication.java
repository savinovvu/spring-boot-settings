package ru.inbox.savinov_vu.conditional;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.inbox.savinov_vu.utils.HelloSayer;

import javax.annotation.Resource;



@SpringBootApplication
public class ConditionalBeanApplication implements CommandLineRunner {

    @Resource(name = "sayAnnotation")
    private HelloSayer helloSayer;


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(ConditionalBeanApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("============== condition bean settings ========");
        System.out.println(helloSayer.toString());
    }


}

