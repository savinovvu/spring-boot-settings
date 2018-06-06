package ru.inbox.savinov_vu.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.inbox.savinov_vu.conditional.condition.*;
import ru.inbox.savinov_vu.utils.HelloSayer;



@Configuration
public class Config {

    //-Dsay=bar
    @Bean
    @Conditional(SayBarCondition.class)
    public HelloSayer sayBar() {
        return new HelloSayer("BAR");
    }


    //-Dsay=foo
    @Bean
    @Conditional(SayFooCondition.class)
    public HelloSayer sayFoo() {
        return new HelloSayer("FOO");
    }


    // property application.yml
    @Bean
    @Conditional(PropertyCondition.class)
    public HelloSayer sayProperty() {
        return new HelloSayer("property");
    }


    @Bean
    @AnnotationConditionSay("propertyConditional")
    public HelloSayer sayAnnotation() {
        return new HelloSayer("annotation");
    }


    //     if not another bean
    @Bean
    @Conditional(DefaultCondition.class)
    public HelloSayer sayDefault() {
        return new HelloSayer("default");
    }

}
