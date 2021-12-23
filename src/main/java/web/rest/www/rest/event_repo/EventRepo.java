package web.rest.www.rest.event_repo;

import web.rest.www.rest.event_service_dto.Event;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface EventRepo extends CrudRepository<Event, Integer> {
    @Query("SELECT u FROM Event u WHERE u.id = ?1")
    Optional<Event> getById(@Param("id") Integer id);

    List<Event> getAllByTitle(String title);

    @Query("SELECT u FROM Event u WHERE u.id = ?1 AND u.title= ?2" +
            "AND u.place= ?3 AND u.speaker=?4 AND u.eventType=?5 " +
            "AND u.dateTime= ?6")
    Event getEventByAllParams(Integer id, String title,
                                        String place, String speaker,
                                        String eventType, Date dateTime);


}
