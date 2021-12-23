package web.rest.www.rest.event_service_api;

import java.util.Date;
import java.util.List;

import web.rest.www.rest.event_service_dto.Event;


public interface EventService {
    Event saveEvent(Event event);

    Event saveEvent(String title, String place, String speaker,
                    String eventType, Date dateTime);

    void updateEvent(Event event);

    Event getEvent(Event event);

    Event getEvent(Integer id, String title, String place,
                   String speaker, String eventType, Date dateTime);

    void deleteEvent(Event event);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}
