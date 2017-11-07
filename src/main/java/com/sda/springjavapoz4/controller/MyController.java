package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.RandomNumberGeneratorService;
import com.sda.springjavapoz4.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private SomeService someService;

    @Autowired
    private RandomNumberGeneratorService smallNumbers;

    //@Qualifier("largeNumbers")
    @Autowired
    private RandomNumberGeneratorService randomNumberGeneratorService;

    @GetMapping("/users01")
    public ModelAndView users() {
        //someService.someAction();
        System.out.println(smallNumbers.generatorNumber());
        return new ModelAndView("home");
    }

    @GetMapping("/contact-us")
    public ModelAndView contactUs() {
        System.out.println(randomNumberGeneratorService.generatorNumber());
        return new ModelAndView("home");
    }
}