package com.sda.springjavapoz4.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberGenerator {

    public String getPhoneNumberName(){
        String randomNumber = RandomStringUtils.random(9, false, true);

        return randomNumber;
    }

}
