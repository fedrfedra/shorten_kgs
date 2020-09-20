package com.example.kgs;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class KgsApplication {

    @Bean
    public Faker faker(){
        return new Faker();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KgsApplication.class, args);
    }

}
