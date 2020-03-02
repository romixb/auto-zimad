package com.todoist.auto;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestAssuredSpecs {

    @Value("${api.key}")
    String x;

    public  RequestSpecification CreateTaskSpec() {

        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBasePath("/v1/tasks")
                .addHeader("Authorization", x)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Request-Id", UUID.randomUUID().toString())
                .build();
    }
}
