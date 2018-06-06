package ru.inbox.savinov_vu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    public String property1;

    public String property2;


    public String getProperty1() {
        return property1;
    }


    public void setProperty1(String property1) {
        this.property1 = property1;
    }


    public String getProperty2() {
        return property2;
    }


    public void setProperty2(String property2) {
        this.property2 = property2;
    }


    @Override
    public String toString() {
        return "\nMyProperties{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
}
