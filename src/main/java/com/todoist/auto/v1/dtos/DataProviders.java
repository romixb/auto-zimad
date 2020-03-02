package com.todoist.auto.v1.dtos;

import com.github.javafaker.Faker;
import com.todoist.auto.v1.dtos.tasks.request.TaskRequestDto;
import org.testng.annotations.DataProvider;

public class DataProviders {

    Faker faker = new Faker();

    @DataProvider(name = "requestTaskCreate")
    public Object[][] dataProvider() {
        return new Object[][] {
                { createTaskRequestBuilder()},
                { createTaskRequestBuilder()},
                { createTaskRequestBuilder()}
        };
    }

    public TaskRequestDto createTaskRequestBuilder(){           //todo: add lang enum
            return TaskRequestDto.builder()
                    .content("Meeting with " + faker.artist().name())
                    .dueLang("en")
                    .dueString("end of month")                              //todo: method for dueString building
                    .priority(4)
                    .build();
    }
}
