package com.hackerrank.github.Service;

import com.hackerrank.github.model.Event;

import java.util.List;
import java.util.Optional;


public interface EventService {

    Long addNewEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    Optional<Event>  updateEvent(Event event);

    void eraseAllEvents();

    Long eraseByEventId(Long id);

    List<Event> getEventsByActorId(Long actorId);

    List<Event> getEventsByRepoId(Long repoId);

    List<Event> getEventsByRepoIdAndActorId(Long repoId,Long actorId);
}
