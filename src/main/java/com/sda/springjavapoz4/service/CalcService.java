package com.sda.springjavapoz4.service;

import org.springframework.stereotype.Component;

//@Component
public class CalcService {

    private String message;

    public CalcService(String message) {
        this.message = message;
    }

    public int sum(int a, int b) {
        System.out.println(message);
        return a + b;
    }

    public int multiply(int a, int b) {
        System.out.println(message);
        return a * b;
    }
}
