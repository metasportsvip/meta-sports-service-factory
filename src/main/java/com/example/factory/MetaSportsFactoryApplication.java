package com.example.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class MetaSportsFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaSportsFactoryApplication.class, args);
        log.info("MetaSports factory Service Start Ok");
    }

}
