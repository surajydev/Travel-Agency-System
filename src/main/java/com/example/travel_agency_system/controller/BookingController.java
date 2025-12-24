package com.example.travel_agency_system.controller;

import com.example.travel_agency_system.entity.Booking;
import com.example.travel_agency_system.Enum.BookingStatus;
import com.example.travel_agency_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    // 🔄 CHANGED
    @Autowired
    private BookingService service;

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        return service.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Query #1
    @GetMapping("/customer/{customerId}")
    public List<Booking> bookingsByCustomer(@PathVariable Long customerId) {
        return service.byCustomer(customerId);
    }

    // Query #4
    @GetMapping("/range")
    public List<Booking> bookingsByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.byDateRange(start, end);
    }

    // Query #7
    @GetMapping("/upcoming")
    public List<Booking> upcomingBookings() {
        return service.upcoming();
    }

    // Query #10
    @GetMapping("/status/{status}")
    public List<Booking> bookingsByStatus(@PathVariable BookingStatus status) {
        return service.byStatus(status);
    }
}
