package ru.manytomany.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.manytomany.dao.EventDao;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;

import java.util.List;

@Service
public class EventService {
    EventDao eventDao;
    @Transactional
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    @Transactional
    public void addEvent(Userevent userevent){
        eventDao.add(userevent);
    }
    @Transactional
    public List<Userevent> usereventList(){
        return eventDao.usereventList();
    }
    @Transactional
    public Userevent findById(int id){
        return eventDao.findEventById(id);
    }
    @Transactional
    public void updateEvent(Userevent userevent){
        eventDao.updateEvent(userevent);
    }
    @Transactional
    public List<Usertime> getEventTime(int id){
         return this.eventDao.getEventTime(id);
    }
}
