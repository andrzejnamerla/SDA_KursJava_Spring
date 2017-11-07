package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.CalcService;
import com.sda.springjavapoz4.service.NumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @Autowired
    private CalcService calcService;

    @Autowired
    //@Qualifier("smallNumbers")
    private NumberGenerator numberGenerator;

    @GetMapping("/calc/add")
    public ModelAndView calcAdd() {
        int firstValue = numberGenerator.generatorNumber();
        int secondValue = numberGenerator.generatorNumber();
        System.out.println(firstValue + " + " + secondValue + " = " + calcService.sum(firstValue, secondValue));
        return new ModelAndView("home");
    }

    @GetMapping("/calc/multiply")
    public ModelAndView calcMultiply() {
        int firstValue = numberGenerator.generatorNumber();
        int secondValue = numberGenerator.generatorNumber();
        System.out.println(firstValue + " * " + secondValue + " = " + calcService.multiply(firstValue, secondValue));
        return new ModelAndView("home");
    }
}
