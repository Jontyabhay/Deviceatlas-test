package com.deviceatlas.deviceatlas_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DeviceAtlasAppConfig {

    @Bean
    public RestTemplate restTemplate() {  // Create a bean for restTemplate to call services
        return new RestTemplate();
    }
}
