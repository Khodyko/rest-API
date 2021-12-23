package web.rest.www.rest.event_service_rest;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.rest.www.rest.event_service_dto.Event;
import web.rest.www.rest.event_service_impl.EventServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventServiceController {
    private final EventServiceImpl eventService;

    @Autowired
    public EventServiceController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Event createEvent(@RequestBody Event event, HttpServletResponse response) {
        Event eventFromDB = eventService.saveEvent(event);
        if (eventFromDB == null) {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        }
        return eventFromDB;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/{title}")
    @ApiImplicitParam(name = "dateTime", required = true, value = "2021-12-20T08:32:11.847Z",
            dataType = "string ", paramType = "query")
    public Event createEvent(@PathVariable(value = "title") String title, String place, String speaker, String eventType,
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime,
                             HttpServletResponse response) {
        Event eventFromDB = eventService.saveEvent(title, place, speaker, eventType, dateTime);
        if (eventFromDB == null) {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        }
        return eventFromDB;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public Event getEvent(Integer id, String title, String place, String speaker,
                          String eventType,
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Param(value = "dateTime") Date dateTime,
                          HttpServletResponse response) {
        Event eventFromDB = eventService.getEvent(id, title, place, speaker, eventType, dateTime);
        if (eventFromDB == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return eventFromDB;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Event getEventByParam(@PathVariable Integer id, HttpServletResponse response) {
        Event eventFromDB = eventService.getById(id);
        if (eventFromDB == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return eventFromDB;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    public Event update(@RequestBody Event event) {
        return event;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/{id}")
    public Event update(@PathVariable Integer id, String title, String place, String speaker,
                        String eventType, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        return new Event(id, title, place, speaker, eventType, dateTime);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(@RequestBody Event event, HttpServletResponse response) {
        if (event == null) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } else {
            eventService.deleteEvent(event);
        }
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Integer id, HttpServletResponse response) {
        Event event = eventService.getById(id);
        if (event == null) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } else {
            eventService.deleteEvent(event);
        }
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/all")
    public List<Event> getAllEvents(HttpServletResponse response) {
        List<Event> events = eventService.getAllEvents();
        if (events == null || events.size() == 0) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{title}")
    public List<Event> getAllEventsByTitle(@PathVariable String title, HttpServletResponse response) {
        List<Event> events = eventService.getAllEventsByTitle(title);
        if (events == null || events.size() == 0) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return null;
    }
}
