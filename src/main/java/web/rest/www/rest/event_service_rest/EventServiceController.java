package web.rest.www.rest.event_service_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import web.rest.www.rest.eventException.NoEventException;
import web.rest.www.rest.event_service_dto.Event;
import web.rest.www.rest.event_service_impl.EventServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventServiceController {
    @Autowired
    EventServiceImpl eventService;

    @PostMapping
    @RequestMapping("/create")
    Event createEvent(@RequestBody Event event) {
        try {
            return eventService.createEvent(event);
        } catch (NoEventException e) {
            e.getMessage();
            return null;
        }
    }

    @PostMapping
    @RequestMapping("/create-param")
    Event createEvent(Integer id, String title, String place, String speaker,
                      String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        try {
            return eventService.createEvent(id, title, place, speaker, eventType, dateTime);
        } catch (NoEventException e) {
            e.getMessage();
            return null;
        }
    }

    @GetMapping
    @RequestMapping("/get")
    Event getEvent(Integer id, String title, String place, String speaker,
                   String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        try {
            return eventService.getEvent(event);
        } catch (NoEventException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    @RequestMapping("/get-by-param")
    Event getEventByParam(Integer id, String title, String place, String speaker,
                          String eventType,
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        System.out.println("works");

        try {
            return eventService.getEvent(id, title, place, speaker, eventType, dateTime);
        } catch (NoEventException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping
    @RequestMapping("/put")
    Event update(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @PutMapping
    @RequestMapping("/put-by-param")
    Event update(Integer id, String title, String place, String speaker,
                 String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        return eventService.updateEvent(event);
    }

    @DeleteMapping
    @RequestMapping("/delete")
    void delete(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }

    @DeleteMapping
    @RequestMapping("/delete-by-param")
    void delete(Integer id, String title, String place, String speaker,
                String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        eventService.deleteEvent(event);
    }

    @GetMapping
    @RequestMapping("/all")
    List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping
    @RequestMapping("/all-by-title")
    List<Event> getAllEventsByTitle(@RequestParam String title) {
        return eventService.getAllEventsByTitle(title);

    }
}
