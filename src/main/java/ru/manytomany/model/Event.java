package ru.manytomany.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Сизиф on 07.07.2017.
 */
@Entity
public class Event {
    private int id;
    private String event;
    private Set<Time> timeSet;

    @ManyToMany(mappedBy = "eventSet")
    public Set<Time> getTimeSet() {
        return timeSet;
    }

    public void setTimeSet(Set<Time> timeSet) {
        this.timeSet = timeSet;
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
    @Column(name = "event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event1 = (Event) o;

        if (id != event1.id) return false;
        if (event != null ? !event.equals(event1.event) : event1.event != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }
}
