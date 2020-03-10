package com.jackiedeng.movies.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Document;
import java.util.ArrayList;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 11:17
 * @Description
 */
/**
 * 默认访问地址为http://localhost:8081/swagger-ui.html*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.jackiedeng.movies.controller"))
//            .paths(PathSelectors.none())
            .build();
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("myGithub","https://github.com/JJJackieDeng","15975403320@163.com");
        return  new ApiInfo(
                "基于Vue+springboot的电影订票系统后端API文档",
                "有志者事竟成",
                "v1.0",
                "https://www.bilibili.com/",
                contact,
                "Apache2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html",
                new ArrayList<>()
        );
    }
}
