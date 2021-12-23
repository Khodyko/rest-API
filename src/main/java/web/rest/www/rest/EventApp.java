package web.rest.www.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventApp.class, args);
    }

    public void run(String... args){
        System.out.println("Let's go!");
    }
}
