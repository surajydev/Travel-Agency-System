package com.example.travel_agency_system.controller;

import com.example.travel_agency_system.entity.Itinerary;
import com.example.travel_agency_system.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

    // 🔄 CHANGED
    @Autowired
    private ItineraryService service;

    @PostMapping
    public Itinerary create(@RequestBody Itinerary itinerary) {
        return service.save(itinerary);
    }

    @GetMapping
    public List<Itinerary> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Itinerary update(@PathVariable Long id, @RequestBody Itinerary itinerary) {
        return service.update(id, itinerary);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Query #3
    @GetMapping("/booking/{bookingId}")
    public List<Itinerary> itinerariesByBooking(@PathVariable Long bookingId) {
        return service.byBooking(bookingId);
    }
}
