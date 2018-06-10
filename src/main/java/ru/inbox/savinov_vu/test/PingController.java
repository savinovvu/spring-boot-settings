package ru.inbox.savinov_vu.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping(){
        return "OK";
    }
}