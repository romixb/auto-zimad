package com.todoist.auto;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@Configuration
public class TestConfig {

    @BeforeSuite
    static void configureRestAssured() {
        RestAssured.baseURI = "https://api.todoist.com/rest";
        RestAssured.filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @AfterSuite
    static void ResetEnvironment(){
        //ResetEnvironment();
    }

}
