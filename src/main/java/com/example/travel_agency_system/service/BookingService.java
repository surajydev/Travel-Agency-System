package com.example.travel_agency_system.service;

import com.example.travel_agency_system.entity.Booking;
import com.example.travel_agency_system.Enum.BookingStatus;
import com.example.travel_agency_system.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository repository;

    // CREATE
    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    // READ ALL
    public List<Booking> getAll() {
        return repository.findAll();
    }

    // UPDATE
    public Booking update(Long id, Booking booking) {
        booking.setId(id);
        return repository.save(booking);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // QUERY #1
    public List<Booking> byCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    // QUERY #4
    public List<Booking> byDateRange(LocalDate start, LocalDate end) {
        return repository.findByBookingDateBetween(start, end);
    }

    // QUERY #7
    public List<Booking> upcoming() {
        return repository.findByBookingDateAfter(LocalDate.now());
    }

    // QUERY #10
    public List<Booking> byStatus(BookingStatus status) {
        return repository.findByStatus(status);
    }

    // QUERY #8
    public List<Booking> byItineraryActivity(String activity) {
        return repository.findByItineraryActivity(activity);
    }

    // QUERY #9
    public List<Object[]> countPerPackage() {
        return repository.countBookingsPerTourPackage();
    }
}
