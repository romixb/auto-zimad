package com.todoist.auto.v1.tasks.create;

import com.todoist.auto.RestAssuredSpecs;
import com.todoist.auto.v1.dtos.projects.ProjectDto;
import com.todoist.auto.v1.dtos.sections.SectionDto;
import com.todoist.auto.v1.dtos.tasks.TaskDto;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@Slf4j
@Component
public class Service {

    @Autowired
    RestAssuredSpecs restAssuredSpecs;

    void cleanOutSections() {
        SectionDto[] tempArray = given().spec(restAssuredSpecs.getSectionsSpec())
                .get()
                .as(SectionDto[].class);
        try {

            Arrays.asList(tempArray).forEach(x ->
                    RestAssured.given().spec(restAssuredSpecs.getSectionsSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }


    }

    void cleanOutProjects() {

        ProjectDto[] tempArray = given().spec(restAssuredSpecs.getProjectSpec())
                .get()
                .as(ProjectDto[].class);
        try {
            Arrays.asList(tempArray).forEach(x ->
                    RestAssured.given().spec(restAssuredSpecs.getProjectSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }


    }

    void cleanOutTasks() {
        TaskDto[] tempArray = given().spec(restAssuredSpecs.createTaskSpec())
                .get()
                .as(TaskDto[].class);
        try {
            Arrays.asList(tempArray).forEach(x ->
                    RestAssured.given().spec(restAssuredSpecs.getProjectSpec())
                            .delete("/{id}", x.getId()));

        } catch (Exception ex) {
            log.debug("Cleanup failed", ex);
            ex.printStackTrace();
        }
    }

}
