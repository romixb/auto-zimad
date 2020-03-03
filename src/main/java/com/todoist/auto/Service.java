package com.todoist.auto;

import com.github.javafaker.Faker;
import com.todoist.auto.v1.dtos.projects.ProjectDto;
import com.todoist.auto.v1.dtos.sections.SectionDto;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@Slf4j
@Component
public class Service {

    @Autowired
    RestAssuredSpecs restAssuredSpecs;

    @Autowired
    Faker faker;

    @Qualifier("dataProviders")
    @Autowired
    DataProviders provider;

    public ProjectDto createProject() {
        log.debug("Create project");
        return given().spec(restAssuredSpecs.getProjectSpec())
                .contentType(ContentType.JSON)
                .with()
                .body(provider.createProjectBuilder())
                .post()
                .then().assertThat().statusCode(200)
                .extract().as(ProjectDto.class);

    }

    public void cleanOutSections() {
        SectionDto[] tempArray = given().spec(restAssuredSpecs.getSectionsSpec())
                .get()
                .as(SectionDto[].class);
        try {

            Arrays.asList(tempArray).forEach(x ->
                    given().spec(restAssuredSpecs.getSectionsSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }


    }

    public void cleanOutProjects() {

        ProjectDto[] tempArray = given().spec(restAssuredSpecs.getProjectSpec())
                .get()
                .as(ProjectDto[].class);
        try {
            Arrays.asList(tempArray).forEach(x ->
                    given().spec(restAssuredSpecs.getProjectSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }


    }

    public void cleanOutTasks() {
        TaskDto[] tempArray = given().spec(restAssuredSpecs.createTaskSpec())
                .get()
                .as(TaskDto[].class);
        try {
            Arrays.asList(tempArray).forEach(x ->
                    given().spec(restAssuredSpecs.getProjectSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }
    }

}
