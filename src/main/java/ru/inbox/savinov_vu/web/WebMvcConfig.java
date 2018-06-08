package ru.inbox.savinov_vu.web;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.DispatcherType;
import java.util.Properties;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

/*    @Resource
    private MyServlet myServlet;


    @Bean
    public ServletRegistrationBean<MyServlet> myServletBean() {
        ServletRegistrationBean<MyServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(myServlet);
        servlet.addUrlMappings("/myServlet");
        return servlet;
    }*/


    @Bean(name = "javamelodyFilter")
    public FilterRegistrationBean<MonitoringFilter> javamelodyFilterBean() {
        FilterRegistrationBean<MonitoringFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.setName("javamelodyFilter");
        registration.setAsyncSupported(true);
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        return registration;
    }


    @Bean(name = "javamelodySessionListener")
    public ServletListenerRegistrationBean<SessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<>(new SessionListener());
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("public/login");
        registry.addRedirectViewController("/", "/home");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Add additional interceptors here
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/").addResourceLocations("/resources/assets/");
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        //Add additional formatters here
    }

//exception resolver
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DataAccessException", "dbError");
        mappings.setProperty("RuntimeException", "error");
        exceptionResolver.setExceptionMappings(mappings);
        exceptionResolver.setDefaultErrorView("error");

        return exceptionResolver;
    }


}
