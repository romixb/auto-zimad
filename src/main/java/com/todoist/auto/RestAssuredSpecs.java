package com.todoist.auto;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredSpecs {
    static RequestSpecification CreateTaskSpec() {
        return new RequestSpecBuilder()
                .setBasePath("/v1/tasks")
                .addHeader("Accept", "application/json")
                .build();
    }
}
