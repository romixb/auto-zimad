package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.AutoApplication;
import com.todoist.auto.RestAssuredSpecs;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;

@SpringBootTest(classes = AutoApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    RestAssuredSpecs restAssuredSpecs;

    @BeforeTest
    void configureRestAssured() {
        RestAssured.baseURI = "https://api.todoist.com/rest"; //Todo: move to properties
        RestAssured.filters(new ResponseLoggingFilter());
    }
}
