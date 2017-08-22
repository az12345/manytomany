package ru.manytomany.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.manytomany.dao.TimeDao;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;

import java.util.List;

@Service
public class TimeService {
    private TimeDao timeDao;

    public void setTimeDao(TimeDao timeDao) {
        this.timeDao = timeDao;
    }
    @Transactional
    public void addTime(Usertime usertime){
        timeDao.addTime(usertime);
    }
    @Transactional
    public List<Usertime> list(){
        return timeDao.usertimeList();
    }
    @Transactional
    public Usertime findById(int id){
        return timeDao.findByIdTime(id);
    }
    @Transactional
    public void updateTime(Usertime usertime){
        timeDao.updateTime(usertime);
    }
    @Transactional
    public List<Userevent> usereventList(int id){
        return timeDao.usereventList(id);
    }
    @Transactional
    public void delete(int id){
        timeDao.delete(id);
    }
}
