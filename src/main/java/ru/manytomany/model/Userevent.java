package ru.manytomany.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Userevent {
    private int id;
    private String name;
    private String event;
    private Set<Usertime> usertimes;

    @ManyToMany(mappedBy = "userevents")
    public Set<Usertime> getUsertimes() {
        return usertimes;
    }

    public void setUsertimes(Set<Usertime> usertimes) {
        this.usertimes = usertimes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @NotNull
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

        Userevent userevent = (Userevent) o;

        if (id != userevent.id) return false;
        if (name != null ? !name.equals(userevent.name) : userevent.name != null) return false;
        if (event != null ? !event.equals(userevent.event) : userevent.event != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }
}
