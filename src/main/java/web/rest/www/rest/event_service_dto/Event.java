package web.rest.www.rest.event_service_dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "place")
    private String place;
    @Column(name = "speaker")
    private String speaker;
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "date_time")
    private Date dateTime;

    public Event(
            Integer id,
            String title,
            String place, String speaker,
            String eventType, Date dateTime) {
        this.id = id;
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return id.equals(event.id) && title.equals(event.title) && place.equals(event.place) && speaker.equals(event.speaker) && eventType.equals(event.eventType) && dateTime.equals(event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, place, speaker, eventType, dateTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", place='").append(place).append('\'');
        sb.append(", speaker='").append(speaker).append('\'');
        sb.append(", eventType='").append(eventType).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
