package com.example.travel_agency_system.controller;

import com.example.travel_agency_system.entity.Destination;
import com.example.travel_agency_system.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    // 🔄 CHANGED
    @Autowired
    private DestinationService service;

    @PostMapping
    public Destination create(@RequestBody Destination destination) {
        return service.save(destination);
    }

    @GetMapping
    public List<Destination> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination destination) {
        return service.update(id, destination);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Query #5
    @GetMapping("/popular")
    public List<Destination> popularDestinations() {
        return service.mostPopular();
    }
}
