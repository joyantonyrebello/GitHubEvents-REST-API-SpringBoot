package com.hackerrank.github.controller;


import com.hackerrank.github.Service.EventService;
import com.hackerrank.github.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class EventsController {

    @Autowired
    private EventService eventService;

    //Add new Event, if ID already exist return status as bad request
    @PostMapping("/events")
    public ResponseEntity<Long> addNewEvent(@RequestBody Event event, HttpServletRequest request){
        Long eventId = eventService.addNewEvent(event);
        if(eventId != -100){
            return new ResponseEntity<Long>(eventId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Long>(eventId, HttpStatus.BAD_REQUEST);
        }
    }
    //List all the Events
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents(HttpServletRequest request) {

        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
    //Fetch an Event
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value="id") Long id){
        Event event = eventService.getEventById(id);
        if(event != null){
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<Event>(event, HttpStatus.NOT_FOUND);
        }

    }

    //Find events matching the given Actor ID
    @GetMapping("/events/actors/{id}")
    public ResponseEntity<List<Event>> getEventsByActorId(@PathVariable(value="id") Long actorId){
        List<Event> events = eventService.getEventsByActorId(actorId);
        if(events.size()>0){
            return new ResponseEntity<List<Event>>(events,HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Event>>(events,HttpStatus.NOT_FOUND);
        }
    }

    //Find events matching the given Repo ID
    @GetMapping("/events/repos/{id}")
    public ResponseEntity<List<Event>> getEventsByRepoId(@PathVariable(value="id") Long repoId){
        List<Event> events = eventService.getEventsByRepoId(repoId);
        if(events.size()>0){
            return new ResponseEntity<List<Event>>(events,HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Event>>(events,HttpStatus.NOT_FOUND);
        }
    }

    //Find events matching the given Repo ID
    @GetMapping("/events/repos/{repoId}/actors/{actorId}")
    public ResponseEntity<List<Event>> getEventsByRepoIdAndActorId(@PathVariable(value="repoId") Long repoId,
                                                                   @PathVariable(value="actorId") Long actorId){
        List<Event> events = eventService.getEventsByRepoIdAndActorId(repoId,actorId);
        if(events.size()>0){
            return new ResponseEntity<List<Event>>(events,HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Event>>(events,HttpStatus.NOT_FOUND);
        }
    }

    //update an Event
    @PutMapping("/events")
    public ResponseEntity<Optional<Event>> updateEventById(@RequestBody Event event){
        Optional<Event> e = eventService.updateEvent(event);
        return new ResponseEntity<Optional<Event>>(e,HttpStatus.OK);
    }
    //Delete all Events
    @DeleteMapping("/erase")
    public ResponseEntity eraseAllEvents(HttpServletRequest request){
        eventService.eraseAllEvents();
        return new ResponseEntity(HttpStatus.OK);
    }

    //Delete a particular Event
    @DeleteMapping("/erase/{id}")
    public String eraseByEventId(@PathVariable(value="id") Long id){
        Long eventId = eventService.eraseByEventId(id);
        return "Success erased record : " + eventId;
    }


}
