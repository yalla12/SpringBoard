package com.sparta.springhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworkApplication.class, args);
    }

}
