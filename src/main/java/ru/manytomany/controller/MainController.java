package ru.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;
import ru.manytomany.service.EventService;
import ru.manytomany.service.TimeService;

import javax.validation.Valid;

@Controller
public class MainController {
    private TimeService timeService;
    private EventService eventService;
    @Autowired(required = true)
    @Qualifier("eventService")
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired(required = true)
    @Qualifier("timeService")
    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("time", new Usertime());
        model.addAttribute("timelist", timeService.list());
        model.addAttribute("event", new Userevent());
        model.addAttribute("eventlist", eventService.usereventList());
        return "index";
    }
    @RequestMapping(value = "/time/add", method = RequestMethod.POST)
    public String addTime(@ModelAttribute Usertime usertime){
        if(usertime.getId()!=0) {
            timeService.updateTime(usertime);
        }else {
            timeService.addTime(usertime);
        }

        return "redirect:/";
    }
    @RequestMapping(value="/time/edit/{id}",method = RequestMethod.GET)
    public String editTime(@PathVariable("id") int id, Model model){

        model.addAttribute("time", timeService.findById(id));
        return "editTime";
    }
    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute Userevent userevent){
        if(userevent.getId() != 0){
            eventService.updateEvent(userevent);
        } else{
           eventService.addEvent(userevent);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/event/edit/{id}", method = RequestMethod.GET)
    public String editEvent(@PathVariable("id") int id, Model model){
        model.addAttribute("event", eventService.findById(id) );
        return "editEvent";
    }
    @RequestMapping(value = "/time/timeevent/{id}", method = RequestMethod.GET)
    public String timeEventListById(@PathVariable("id") int id, Model model){
        model.addAttribute("event", new Userevent());
        model.addAttribute("eventlist",timeService.usereventList(id));
        return "timeevent";
    }
    @RequestMapping(value = "/event/eventtime/{id}", method = RequestMethod.GET)
    public String eventTime(@PathVariable("id") int id, Model model){
        model.addAttribute("time", new Usertime());
        model.addAttribute("timelist", eventService.getEventTime(id));
        return "eventtime";
    }

    /**
     * Delete event.
     * @param id event id.
     * @return redirect to index.
     */
    @RequestMapping(value = "/event/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        this.eventService.delete(id);
        return "redirect:/";
    }

}
