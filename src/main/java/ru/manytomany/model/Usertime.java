package ru.manytomany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
public class Usertime {
    private int id;
    private Time time;
    private Date date;

    private List<Userevent> userevents;
    @JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "events_happens1", joinColumns = @JoinColumn(name = "time_id"),
    inverseJoinColumns = @JoinColumn(name = "event_id"))
//    , insertable = false
    public List<Userevent> getUserevents() {
        return userevents;
    }

    public void setUserevents(List<Userevent> userevents) {
        this.userevents = userevents;
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
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @NotNull
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usertime usertime = (Usertime) o;

        if (id != usertime.id) return false;
        if (time != null ? !time.equals(usertime.time) : usertime.time != null) return false;
        if (date != null ? !date.equals(usertime.date) : usertime.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
