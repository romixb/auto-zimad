package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.AutoApplication;
import com.todoist.auto.RestAssuredSpecs;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = AutoApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {


    @Autowired
    RestAssuredSpecs restAssuredSpecs;

    @BeforeSuite
    void configureRestAssured() {
        RestAssured.baseURI = "https://api.todoist.com/rest"; //Todo: move to properties
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @AfterClass
    void cleanUp(){
        cleanOutTasks();
    }

    private void cleanOutTasks() {
        TaskDto[] tempArray = given().spec(restAssuredSpecs.CreateTaskSpec())
                .get()
                .as(TaskDto[].class);

         Arrays.asList(tempArray).forEach(x -> RestAssured.given()
                 .header("Authorization", "Bearer 942125831200b2fe2dc3841cdbb2de16e34eed3b")
                 .delete(String.format("https://api.todoist.com/rest/v1/tasks/%s", x.getId())));
    }

}
