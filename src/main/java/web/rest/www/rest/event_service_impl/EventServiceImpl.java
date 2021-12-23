package web.rest.www.rest.event_service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.rest.www.rest.event_repo.EventRepo;
import web.rest.www.rest.event_service_api.EventService;
import web.rest.www.rest.event_service_dto.Event;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Event saveEvent(Event event) {
        eventRepo.save(event);
        return this.getById(event.getId());
    }

    @Override
    public Event saveEvent(String title, String place, String speaker,
                           String eventType, Date dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        eventRepo.save(event);
        return this.getById(event.getId());
    }

    @Override
    public Event getEvent(Event event) {
        return this.getById(event.getId());
    }

    @Override
    public Event getEvent(Integer id, String title, String place,
                          String speaker, String eventType, Date dateTime) {
        return eventRepo.getEventByAllParams(id, title, place, speaker, eventType, dateTime);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepo.save(event);
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepo.delete(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepo.getAllByTitle(title);
    }

    public Event getById(Integer id) {
        return eventRepo.getById(id).orElse(null);
    }
}
