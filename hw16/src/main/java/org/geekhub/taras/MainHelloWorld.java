package org.geekhub.taras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainHelloWorld {
    public static void main(String[] args) {
        SpringApplication.run(MainHelloWorld.class, args);

        System.out.println("Started Application on http://localhost:8080/welcome");
    }
    
}