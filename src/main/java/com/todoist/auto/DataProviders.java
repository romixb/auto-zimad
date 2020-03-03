package com.todoist.auto;

import com.github.javafaker.Faker;
import com.todoist.auto.v1.dtos.projects.ProjectDto;
import com.todoist.auto.v1.dtos.tasks.request.TaskRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

@Component
public class DataProviders {

    @Autowired
    Faker faker;

    @DataProvider(name = "requestTaskCreate")
    public Object[][] dataSupplier() {
        return new Object[][] {
                { createTaskRequestBuilder()},
                { createTaskRequestBuilder()},
                { createTaskRequestBuilder()}
        };
    }

    public ProjectDto createProjectBuilder(){           //todo: add lang enum
        return ProjectDto.builder().name(faker.music().key()).build();

    }
    public TaskRequestDto createTaskRequestBuilder(){           //todo: add lang enum
            return TaskRequestDto.builder()
                    .content("Meeting with " + faker.artist().name())
                    .dueLang("en")
                    .dueString("end of month")                              //todo: method for dueString building
                    .priority(4)
                    .build();
    }

    public TaskRequestDto createTaskRequestWithProject(long projectId){
        return TaskRequestDto.builder()
                .content("Meeting with " + faker.artist().name())
                .projectId(projectId)
                .dueLang("en")
                .dueString("end of month")
                .priority(4)
                .build();
    }

}
