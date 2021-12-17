package web.rest.www.rest.event_repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import web.rest.www.rest.event_service_dto.Event;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface EventRepo extends CrudRepository<Event, Integer> {
    @Query("SELECT u FROM Event u WHERE u.id = ?1")
    Optional<Event> getById(@Param("id") Integer id);

    List<Event> getAllByTitle(String title);


}
