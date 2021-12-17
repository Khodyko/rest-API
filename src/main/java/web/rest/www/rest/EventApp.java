package web.rest.www.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import web.rest.www.rest.event_service_api.EventService;
import web.rest.www.rest.event_service_dto.Event;

import java.util.Date;

@SpringBootApplication
public class EventApp implements CommandLineRunner {

    @Autowired
    EventService eventService;

    public static void main(String[] args) {
        SpringApplication.run(EventApp.class, args);
    }


    public void run(String... args) throws Exception {
//        eventService.createEvent(new Event("title", "place",
//                "speaker", "eventType", new Date(System.currentTimeMillis())));
//
//        eventService.createEvent(new Event("title2", "place2",
//                "speaker2", "eventType2", new Date(System.currentTimeMillis())));
        System.out.println("Let's go!");
    }

}
