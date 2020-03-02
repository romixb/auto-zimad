package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.v1.dtos.DataProviders;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import com.todoist.auto.v1.dtos.tasks.request.TaskRequestDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class CreateTasksTests extends BaseTest {

    @Test(dataProvider = "requestTaskCreate", dataProviderClass = DataProviders.class)
    public void checkTaskAvailablityAndResponse(TaskRequestDto taskRequest) {

        given().spec(restAssuredSpecs.CreateTaskSpec())
                .with()
                .body(taskRequest)
                .post()
                .then().assertThat().statusCode(200)
                .extract().as(TaskDto.class);

    }


}
