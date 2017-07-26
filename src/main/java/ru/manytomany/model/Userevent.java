package ru.manytomany.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Entity
public class Userevent {
    private int id;
    private String name;
  //  @Min(value=2, message = " more them one")
   // @Max(value = 5, message = "litle then 5")
    private String event;
    private List<Usertime> usertimes;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "events_happens", joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "time_id"))
    public List<Usertime> getUsertimes() {
        return usertimes;
    }

    public void setUsertimes(List<Usertime> usertimes) {
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
