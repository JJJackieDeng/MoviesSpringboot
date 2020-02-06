package com.example.demo.controller;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieOrder {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        SpringApplication.run(HelloWorldController.class,args);
    }
}

