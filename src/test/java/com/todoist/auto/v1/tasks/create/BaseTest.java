package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.AutoApplication;
import com.todoist.auto.RestAssuredSpecs;
import com.todoist.auto.Service;
import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@Slf4j
@SpringBootTest(classes = AutoApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {


    @Autowired
    Service service;

    @Autowired
    RestAssuredSpecs restAssuredSpecs;

    @BeforeSuite
    void SetupTestData() {

    }

    @BeforeSuite
    void ConfigureRestAssured() {
        RestAssured.baseURI = "https://api.todoist.com/rest"; //Todo: move to properties
        RestAssured.filters(new ResponseLoggingFilter());
        log.debug("Before Suite execution. Setup Rest-Assured");
    }


    @AfterSuite
    void CleanUp() {
        service.cleanOutTasks();
        service.cleanOutProjects();
        service.cleanOutSections();
    }

}
