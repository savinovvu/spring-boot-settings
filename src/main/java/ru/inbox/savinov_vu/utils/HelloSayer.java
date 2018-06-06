package ru.inbox.savinov_vu.utils;

public class HelloSayer {

    String hello;


    public HelloSayer(String hello) {
        this.hello = "hello " + hello;
    }


    @Override
    public String toString() {
        return hello;
    }
}
