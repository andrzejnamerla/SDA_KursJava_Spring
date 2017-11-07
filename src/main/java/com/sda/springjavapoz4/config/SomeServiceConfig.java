package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SomeServiceConfig {

    @Primary
    @Bean
    public SomeService someService(){
        return new SomeService("My secret message?");
    }

    @Bean
    public SomeService aboutService(){
        return new SomeService("About section^");
    }
}
