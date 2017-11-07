package com.sda.springjavapoz4.service;

import java.util.Random;

//@Component
public class RandomNumberGeneratorService implements NumberGenerator{

    private int offset;
    private int bound;

    private Random random;

    public RandomNumberGeneratorService(int bound, int offset){
        this.random = new Random();
        this.offset = offset;
        this.bound = bound;
    }

    public RandomNumberGeneratorService(int bound) {
        this(bound,0);
    }

    public RandomNumberGeneratorService(){
        this(10,0);
    }

    @Override
    public int generatorNumber(){
        return random.nextInt(bound)+ offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
