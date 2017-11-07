package com.sda.springjavapoz4.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component
//@Primary

public class IncrementalNumberGeneratorService implements NumberGenerator {

    private int counter;

    @Override
    public int generatorNumber() {
        return counter++;
    }
}
