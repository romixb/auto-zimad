package com.todoist.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class TestConfig {

    @Bean
    public RestAssuredSpecs getRestAssuredSpecs(){
        return new RestAssuredSpecs();
    }

}
