package web.rest.www.rest.event_service_rest;


import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Event createEvent(@RequestBody Event event) {
        try {
            return eventService.createEvent(event);
        } catch (NoEventException e) {
            e.getMessage();
            return null;
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/create-param", method = RequestMethod.POST)
    @ApiImplicitParam(name="dateTime", required  =  true ,value = "2021-12-20T08:32:11.847Z", dataType  =  "string ", paramType = "query")
    Event createEvent(String title, String place, String speaker,
                      String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
//        Date dateTimeConverted= Date.from(Instant.parse(dateTime));
        try {
            return eventService.createEvent( title, place, speaker, eventType, dateTime);
        } catch (NoEventException e) {
            e.getMessage();
            return null;
        }
    }


    @RequestMapping(value="/get", method = RequestMethod.GET)
    Event getEvent(Integer id, String title, String place, String speaker,
                   String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Param(value = "dateTime") Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        try {
            return eventService.getEvent(event);
        } catch (NoEventException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/get-by-param", method = RequestMethod.GET)
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

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/put", method =RequestMethod.PUT)
    Event update(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/put-by-param", method = RequestMethod.PUT)
    Event update(Integer id, String title, String place, String speaker,
                 String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        return eventService.updateEvent(event);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    void delete(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/delete-by-param", method = RequestMethod.DELETE)
    void delete(Integer id, String title, String place, String speaker,
                String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        Event event = new Event(id, title, place, speaker, eventType, dateTime);
        eventService.deleteEvent(event);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/all-by-title", method = RequestMethod.GET)
    List<Event> getAllEventsByTitle(@RequestParam String title) {
        return eventService.getAllEventsByTitle(title);
    }
}
