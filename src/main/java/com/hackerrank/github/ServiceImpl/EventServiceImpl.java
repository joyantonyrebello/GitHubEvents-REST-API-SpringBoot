package com.hackerrank.github.ServiceImpl;

import com.hackerrank.github.Repository.EventRepository;
import com.hackerrank.github.Service.EventService;
import com.hackerrank.github.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Long addNewEvent(Event event) {
        Event event1 = null;
        Optional<Event> e = eventRepository.findById(event.getId());
        if(e.isPresent()){
            return -100L;
        } else {
            event1 = eventRepository.save(event);
            return event1.getId();
        }
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList<Event>();
        eventRepository.findAll()
                        .forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> e = eventRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        } else {
            Event ev = null;
            return ev;
        }

    }

    @Override
    public Optional<Event> updateEvent(Event event) {
        Optional<Event> e = eventRepository.findById(event.getId());
        if(e.isPresent()){
            Event e1 = e.get();
            e1.setId(event.getId());
            e1.setType(event.getType());
            eventRepository.save(e1);
        }
        return e;
    }

    @Override
    public void eraseAllEvents(){
        eventRepository.deleteAll();
        return;
    }

    @Override
    public Long eraseByEventId(Long id){
        eventRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Event> getEventsByActorId(Long actorId) {
        List<Event> events = eventRepository.findByActorIdOrderByIdAsc(actorId);
        return events;
    }

    @Override
    public List<Event> getEventsByRepoId(Long repoId) {
        List<Event> events = eventRepository.findByRepoIdOrderByIdAsc(repoId);
        return events;
    }

    @Override
    public List<Event> getEventsByRepoIdAndActorId(Long repoId, Long actorId) {
        List<Event> events = eventRepository.findByRepoIdAndActorIdOrderByIdAsc(repoId,actorId);
        return events;
    }

}
