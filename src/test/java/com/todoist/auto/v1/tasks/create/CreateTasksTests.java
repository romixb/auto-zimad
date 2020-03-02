package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.DataProviders;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import com.todoist.auto.v1.dtos.tasks.request.TaskRequestDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class CreateTasksTests extends BaseTest {

    @Test(dataProvider = "requestTaskCreate", dataProviderClass = DataProviders.class, groups = "smoke")
    public void checkTaskAvailabilityAndResponse(TaskRequestDto taskRequest) {

        given().spec(restAssuredSpecs.createTaskSpec())
                .with()
                .body(taskRequest)
                .post()
                .then().assertThat().statusCode(200)
                .extract().as(TaskDto.class);

    }




}
