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
public class TimeDao {
    SessionFactory sessionFactory ;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addTime(Usertime usertime){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(usertime);
    }
    public List<Usertime> usertimeList(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Usertime> list = session.createQuery("from Usertime ").list();
        return list;
    }
    public Usertime findByIdTime(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Usertime usertime = (Usertime) session.load(Usertime.class, new Integer(id));
        usertime.getTime();
        return usertime;
    }
    public void updateTime(Usertime usertime){
        Session session = this.sessionFactory.getCurrentSession();
//        Usertime usertimeUpdate= findByIdTime(usertime.getId());
////        usertimeUpdate.setId(usertime.getId());
//        usertimeUpdate.setDate(usertime.getDate());
//        usertimeUpdate.setUserevents(usertime.getUserevents());
        session.update(usertime);
    }
    public List<Userevent> usereventList(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Usertime usertime = (Usertime) session.load(Usertime.class, new Integer(id));
        Set<Userevent> usereventSet = new HashSet<>();
        usereventSet = usertime.getUserevents();
        List<Userevent> usereventList = new ArrayList<>(usereventSet);
        return usereventList;

    }
}