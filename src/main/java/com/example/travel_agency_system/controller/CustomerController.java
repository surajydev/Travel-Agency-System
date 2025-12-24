package com.example.travel_agency_system.controller;

import com.example.travel_agency_system.entity.Customer;
import com.example.travel_agency_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    // 🔄 CHANGED: using @Autowired
    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Query #6
    @GetMapping("/package/{packageId}")
    public List<Customer> customersByPackage(@PathVariable Long packageId) {
        return service.customersByTourPackage(packageId);
    }
}
