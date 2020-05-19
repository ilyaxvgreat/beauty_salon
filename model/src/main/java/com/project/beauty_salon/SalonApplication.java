package com.project.beauty_salon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SalonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalonApplication.class, args);
    }
}
