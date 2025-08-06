package com.scaler.productserviceaug25.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate createRestTemplateBean() {
        return new RestTemplate();
    }
}
