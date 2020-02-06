package com.JackieTeng.movies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2019/12/8 23:11
 * @Description
 */
@Component
public class NeoProperties {
    @Value("${com.example.demo.title}")
    private String title;
    @Value("$com.example.demo.description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
