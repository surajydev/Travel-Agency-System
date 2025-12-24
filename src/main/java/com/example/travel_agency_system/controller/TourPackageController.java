package com.example.travel_agency_system.controller;

import com.example.travel_agency_system.entity.TourPackage;
import com.example.travel_agency_system.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TourPackageController {

    // 🔄 CHANGED
    @Autowired
    private TourPackageService service;

    @PostMapping
    public TourPackage create(@RequestBody TourPackage tourPackage) {
        return service.save(tourPackage);
    }

    @GetMapping
    public List<TourPackage> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public TourPackage update(@PathVariable Long id, @RequestBody TourPackage tourPackage) {
        return service.update(id, tourPackage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Query #2
    @GetMapping("/destination/{city}")
    public List<TourPackage> packagesByDestination(@PathVariable String city) {
        return service.byDestinationCity(city);
    }
}
