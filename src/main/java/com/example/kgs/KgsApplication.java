package com.example.kgs;

import com.example.kgs.services.ShortLinkGetter;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KgsApplication {

    @Bean
    public Faker faker(){
        return new Faker();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KgsApplication.class, args);
        ShortLinkGetter shortLinkGetter = context.getBean(ShortLinkGetter.class);
        shortLinkGetter.getShortLink();

    }

}
