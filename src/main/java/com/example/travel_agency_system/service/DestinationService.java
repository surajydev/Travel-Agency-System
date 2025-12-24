package com.example.travel_agency_system.service;

import com.example.travel_agency_system.entity.Destination;
import com.example.travel_agency_system.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository repository;

    // CREATE
    public Destination save(Destination destination) {
        return repository.save(destination);
    }

    // READ ALL
    public List<Destination> getAll() {
        return repository.findAll();
    }

    // UPDATE
    public Destination update(Long id, Destination destination) {
        destination.setId(id);
        return repository.save(destination);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // QUERY #5
    public List<Destination> mostPopular() {
        return repository.findMostPopularDestinations();
    }
}
