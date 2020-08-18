package com.hackerrank.github.ServiceImpl;

import com.hackerrank.github.Repository.EventRepository;
import com.hackerrank.github.Service.EventService;
import com.hackerrank.github.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }

    @Override
    public Long addNewEvent(Event event) {
        Event event1 = eventRepository.save(event);
        return event1.getId();
    }
}
