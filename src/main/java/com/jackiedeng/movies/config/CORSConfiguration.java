package com.jackiedeng.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.rmi.registry.Registry;

import static sun.tools.jconsole.Messages.ALL;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 18:35
 * @Description
 */
@Configuration
public class CORSConfiguration implements WebMvcConfigurer {


         @Override
         public void addCorsMappings(CorsRegistry registry) {
             // 限制了路径和域名的访问
             /*registry.addMapping("/api*").allowedOrigins("http://localhost:8081");*/
             registry.addMapping("/**")
                     .allowedOrigins(ALL)
                     .allowedMethods(ALL)
                     .allowedHeaders(ALL)
                     .allowCredentials(true);
         }

}
