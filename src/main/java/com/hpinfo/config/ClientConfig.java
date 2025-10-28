package com.hpinfo.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "create-user")
@Setter
@Getter
@ToString
public class ClientConfig {

    private String host;
    @JsonProperty("user")
    private String user;

}
