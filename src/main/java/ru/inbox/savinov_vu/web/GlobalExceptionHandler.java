package ru.inbox.savinov_vu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;



@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(HttpServletRequest request, DataAccessException ex) {
        logger.info("DataAccessException Occurred:: URL=" + request.getRequestURL());
        return "db_error";
    }


    @ExceptionHandler(ServletRequestBindingException.class)
    public String servletRequestBindingException(ServletRequestBindingException e) {
        logger.error("ServletRequestBindingException occurred: " + e.getMessage());
        return "validation_error";
    }
}
