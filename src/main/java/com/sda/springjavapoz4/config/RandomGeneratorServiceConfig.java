package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.RandomNumberGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RandomGeneratorServiceConfig {

    @Profile("dev")
    @Bean
    public RandomNumberGeneratorService smallNumbers(){
        return new RandomNumberGeneratorService(100);
    }

    @Profile("prod")
    @Bean
    public RandomNumberGeneratorService largeNumbers(){
        RandomNumberGeneratorService randomNumberGeneratorService = new RandomNumberGeneratorService();
        randomNumberGeneratorService.setBound(1000);
        randomNumberGeneratorService.setOffset(1000);
        return randomNumberGeneratorService;
    }

}
