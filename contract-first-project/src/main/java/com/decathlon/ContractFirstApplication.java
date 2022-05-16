package com.decathlon;

import com.decathlon.bike.ApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ContractFirstApplication {

    public static void main(String[] args) {
        new SpringApplication(ContractFirstApplication.class).run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath("http://localhost:8080/bikes/v1");
    }

}
