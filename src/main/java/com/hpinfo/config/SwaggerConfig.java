package com.hpinfo.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public GroupedOpenApi groupedOpenApi(SwaggerUiConfigParameters swaggerUiConfigParameters) {
        return GroupedOpenApi.builder()
                .group("employee-onboarding-services")
                .packagesToScan("com.hpinfo.controller")
                .build();
    }
}
