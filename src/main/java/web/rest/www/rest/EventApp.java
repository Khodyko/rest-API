package web.rest.www.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import web.rest.www.rest.event_service_api.EventService;


@SpringBootApplication
public class EventApp implements CommandLineRunner {

    @Autowired
    EventService eventService;

    public static void main(String[] args) {
        SpringApplication.run(EventApp.class, args);
    }


    public void run(String... args) throws Exception {
        System.out.println("Let's go!");
    }

}
