package com.jackiedeng.movies;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.jackiedeng.movies.mapper")
public class MovieOrder {
    public static void main(String[] args) {
        SpringApplication.run(MovieOrder.class,args);
    }
    
}

