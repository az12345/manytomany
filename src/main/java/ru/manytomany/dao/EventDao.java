package ru.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class EventDao {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Userevent userevent){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(userevent);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    public List<Userevent> usereventList(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Userevent").list();
    }
    public Userevent findEventById(int id){
        Session session = sessionFactory.getCurrentSession();
        Userevent userevent = (Userevent) session.get(Userevent.class, id);
        userevent.getName();
        return userevent;
    }
    public void updateEvent(Userevent userevent){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Userevent usereventUpdate = (Userevent) session.get(Userevent.class, userevent.getId());
        usereventUpdate.setName(userevent.getName());
        usereventUpdate.setEvent(userevent.getEvent());
        session.saveOrUpdate(usereventUpdate);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    public List<Usertime> getEventTime(int id){
        Session session = sessionFactory.openSession();
        Userevent userevent= (Userevent ) session.get(Userevent.class, new Integer(id));
//        Set<Usertime> usertimeSet =userevent.getUsertimes();
//        List<Usertime> usertimes = new ArrayList<>(usertimeSet);

        session.flush();
        session.close();
        return new ArrayList<>(userevent.getUsertimes());

    }

    /**
     * Delete event model by id.
     * @param id event id.
     */
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Userevent event = new Userevent();
            event.setId(id);
            session.delete(event);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}
