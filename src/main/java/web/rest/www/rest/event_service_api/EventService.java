package web.rest.www.rest.event_service_api;

import web.rest.www.rest.eventException.NoEventException;
import web.rest.www.rest.event_service_dto.Event;

import java.util.Date;
import java.util.List;


public interface EventService {
    Event createEvent(Event event) throws NoEventException;

    Event createEvent( String title, String place, String speaker,
                      String eventType, Date dateTime) throws NoEventException;

    Event updateEvent(Event event);

    void updateEvent(Integer id, String title, String place, String speaker,
                     String eventType, Date dateTime);

    Event getEvent(Event event) throws NoEventException;

    Event getEvent(Integer id, String title, String place, String speaker,
                   String eventType, Date dateTime) throws NoEventException;

    void deleteEvent(Event event);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}
