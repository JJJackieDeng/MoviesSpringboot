package com.jackiedeng.movies;



import com.jackiedeng.movies.controller.userController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieOrder {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        SpringApplication.run(userController.class,args);
    }
}

