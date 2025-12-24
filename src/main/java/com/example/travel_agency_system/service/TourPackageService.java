package com.example.travel_agency_system.service;

import com.example.travel_agency_system.entity.TourPackage;
import com.example.travel_agency_system.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageRepository repository;

    // CREATE
    public TourPackage save(TourPackage tourPackage) {
        return repository.save(tourPackage);
    }

    // READ ALL
    public List<TourPackage> getAll() {
        return repository.findAll();
    }

    // UPDATE
    public TourPackage update(Long id, TourPackage tourPackage) {
        tourPackage.setId(id);
        return repository.save(tourPackage);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // QUERY #2
    public List<TourPackage> byDestinationCity(String city) {
        return repository.findByDestinationCity(city);
    }
}
