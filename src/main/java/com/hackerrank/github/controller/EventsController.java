package com.hackerrank.github.controller;

import com.hackerrank.github.Service.EventService;
import com.hackerrank.github.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EventsController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity<Long> addNewEvent(@RequestBody Event event, HttpServletRequest request){
        Long eventId = eventService.addNewEvent(event);
        return new ResponseEntity<Long>(eventId, HttpStatus.CREATED);
    }



}
