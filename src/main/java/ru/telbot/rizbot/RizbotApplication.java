package ru.telbot.rizbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RizbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RizbotApplication.class, args);

    }

}
