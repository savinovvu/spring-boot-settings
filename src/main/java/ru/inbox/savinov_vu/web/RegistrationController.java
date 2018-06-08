package ru.inbox.savinov_vu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;


@Controller
public class RegistrationController {



    @Resource
    UserValidator validator;

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String handleRegistration(@Valid User user, BindingResult result) {
        validator.validate(user, result);
        if(result.hasErrors()){
            return "registration";
        }
        return "redirect:/login";
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleCustomerNotFoundException(RuntimeException ex)
    {
        ModelAndView model = new ModelAndView("error/404");
        model.addObject("exception", ex);
        return model;
    }




}