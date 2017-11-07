package com.sda.springjavapoz4.service.generator;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class LastNameGenerator {

    public String getRandomLastName(){
        return RandomStringUtils.randomAlphabetic(8).toUpperCase();
    }

}
