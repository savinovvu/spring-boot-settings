package ru.inbox.savinov_vu.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* @WebMvcTest, @DataJpaTest, @DataMongoTest, @JdbcTest, and
@JsonTest
* */

@SpringBootApplication
/*@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})*/
public class SpringBootTestingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestingDemoApplication.class, args);
    }
}
