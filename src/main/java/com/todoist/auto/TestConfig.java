package com.todoist.auto;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @BeforeAll
    static void configureRestAssured() {
        RestAssured.baseURI = "https://api.todoist.com/rest";
        RestAssured.filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @AfterAll
    static void ResetEnvironment(){
        //ResetEnvironment();
    }

}
