package com.todoist.auto;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static io.restassured.config.EncoderConfig.encoderConfig;

@Component
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestAssuredSpecs {

    @Value("${api.key}")    //todo: hide on test execution side
            String x;

    public RequestSpecification CreateTaskSpec() {
        return new RequestSpecBuilder().setConfig(CreateTaskConfig())
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .setBasePath("/v1/tasks")
                .addHeader("Authorization", x)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Request-Id", UUID.randomUUID().toString())
                .build();
    }

    public RestAssuredConfig CreateTaskConfig() {
        return RestAssuredConfig.config().
                encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
    }
}