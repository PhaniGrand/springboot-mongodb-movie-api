package com.example.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000, http://10.5.0.2:3000", allowCredentials = "true", allowedHeaders = "*")
public class SpringbootMongodbMovieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbMovieApiApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("http://localhost:3000").allowCredentials(true);
//            }
//        };
//    }

}
