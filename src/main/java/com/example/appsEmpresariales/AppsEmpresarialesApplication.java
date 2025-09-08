package com.example.appsEmpresariales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AppsEmpresarialesApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppsEmpresarialesApplication.class, args);
    }
}
