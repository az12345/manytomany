package ru.manytomany.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Сизиф on 07.07.2017.
 */
@Entity
public class Time {
    private int id;
    private Timestamp time;
    private Set<Event> eventSet;
    @ManyToMany()
    @JoinTable(name= "event_time", joinColumns = @JoinColumn(name="time_id"),
    inverseJoinColumns = @JoinColumn(name = "event_id"))
    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time1 = (Time) o;

        if (id != time1.id) return false;
        if (time != null ? !time.equals(time1.time) : time1.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
