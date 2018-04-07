package com.szt.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringbootJpaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootJpaApplication.class, args);
        System.in.read();

    }
}
