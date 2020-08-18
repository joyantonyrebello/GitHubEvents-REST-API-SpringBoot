package com.hackerrank.github.Service;

import com.hackerrank.github.model.Event;
import org.springframework.stereotype.Component;


public interface EventService {

    void deleteAll();

    Long addNewEvent(Event event);
}
