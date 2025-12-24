package com.example.travel_agency_system.repository;

import com.example.travel_agency_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("""
        SELECT DISTINCT c
        FROM Customer c
        JOIN c.bookings b
        WHERE b.tourPackage.id = :packageId
    """)
    List<Customer> findCustomersByTourPackage(Long packageId);
}
