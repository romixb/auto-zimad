package com.todoist.auto.v1.tasks.create;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateTasksTests {

    @Test
    public void TestTest(){
        given()
                .get("http://google.com")
                .then().assertThat().statusCode(200);
    }


}
