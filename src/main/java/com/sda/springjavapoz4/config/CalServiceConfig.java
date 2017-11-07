package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.CalcService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CalServiceConfig {

    @Profile("dev")
    @Bean
    public CalcService messOne(){
        return new CalcService("R U there yet?");
    }

    @Profile("prod")
    @Bean
    public CalcService messTwo(){
        return new CalcService("Boom!!!");
    }
}
