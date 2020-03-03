package com.todoist.auto.v1.tasks.create;

import com.github.javafaker.Faker;
import com.todoist.auto.DataProviders;
import com.todoist.auto.Service;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import com.todoist.auto.v1.dtos.tasks.request.TaskRequestDto;
import io.qameta.allure.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class CreateTasksTests extends BaseTest {

    @Autowired
    Service service;

    @Autowired
    Faker faker;

    @Qualifier("dataProviders")
    @Autowired
    DataProviders dataProvider;

    @Test(dataProvider = "requestTaskCreate", dataProviderClass = DataProviders.class, groups = {"smoke", "positive"})
    @Description("Test")
    public void checkTaskAvailabilityAndResponse(TaskRequestDto taskRequest) {

        given().spec(restAssuredSpecs.createTaskSpec())
                .with()
                .body(taskRequest)
                .post()
                .then().assertThat().statusCode(200)
                .extract().as(TaskDto.class);

    }


    @Test(groups= {"extended", "positive"})
    @Description("Check that a task can be linked to a valid project")
    public void checkProjectIdConsistency() {

        long currentProjectId = service.createProject().getId();

        TaskDto response= given().spec(restAssuredSpecs.createTaskSpec())
                .with()
                .body(dataProvider.createTaskRequestWithProject(currentProjectId))
                .post()
                .then().assertThat().statusCode(200)
                .extract().as(TaskDto.class);

        Assert.assertEquals(response.getProjectId(), currentProjectId);
    }



}
