package ru.inbox.savinov_vu.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class GenericErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";


    @RequestMapping(ERROR_PATH)
    public String error() {
        return "errorPage.html";
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
