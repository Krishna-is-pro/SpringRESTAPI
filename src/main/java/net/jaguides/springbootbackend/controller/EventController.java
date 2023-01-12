package net.jaguides.springbootbackend.controller;
import net.jaguides.springbootbackend.exception.ResourceNotFoundException;
import net.jaguides.springbootbackend.model.Event;
import net.jaguides.springbootbackend.repository.EventRepository;
import net.jaguides.springbootbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventRepository.findAll();


        }

//build create  event rest api
    @PostMapping
    public Event createEvent(@RequestBody Event event)
    {
        return eventRepository.save(event);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveEvents(@RequestBody List<Event> events){

        eventService.saveEvents(events);
        System.out.println("Data saved");
        return new ResponseEntity<>(HttpStatus.OK);

    }


    // buil get event by id rest api

    @GetMapping({"id"})
    public ResponseEntity<Event> getEventById(@PathVariable long id){
        Event event = eventRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Event not exist with id:"+id));
        return ResponseEntity.ok(event);
    }
    // build update event REST API
    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id,@RequestBody Event eventDetails) {
        Event updateEvent= eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event does not exist with id: " + id));

        updateEvent.setEventname(eventDetails.getEventname());
        updateEvent.setEventlocation(eventDetails.getEventlocation());
        updateEvent.setDate(eventDetails.getDate());

        eventRepository.save(updateEvent);

        return ResponseEntity.ok(updateEvent);
    }

    // build delete event  REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable long id){

     Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not exist with id: " +id));

        eventRepository.delete(event);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}

