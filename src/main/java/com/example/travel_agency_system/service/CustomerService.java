package com.example.travel_agency_system.service;


import com.example.travel_agency_system.entity.Customer;
import com.example.travel_agency_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    // CREATE
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    // READ ALL
    public List<Customer> getAll() {
        return repository.findAll();
    }

    // UPDATE
    public Customer update(Long id, Customer customer) {
        customer.setId(id);
        return repository.save(customer);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // QUERY #6
    public List<Customer> customersByTourPackage(Long packageId) {
        return repository.findCustomersByTourPackage(packageId);
    }
}
