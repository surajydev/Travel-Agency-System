package com.example.travel_agency_system.service;

import com.example.travel_agency_system.entity.Booking;
import com.example.travel_agency_system.entity.Itinerary;
import com.example.travel_agency_system.repository.BookingRepository;
import com.example.travel_agency_system.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository repository;

    @Autowired
    private BookingRepository bookingRepository;

    public Itinerary save(Itinerary itinerary) {

        if (itinerary.getBooking() != null && itinerary.getBooking().getId() != null) {

            Booking booking = bookingRepository.findById(
                    itinerary.getBooking().getId()
            ).orElseThrow(() -> new RuntimeException("Booking not found"));

            itinerary.setBooking(booking); // 🔥 THIS IS THE FIX
        }

        return repository.save(itinerary);
    }

    // READ ALL
    public List<Itinerary> getAll() {
        return repository.findAll();
    }

    // UPDATE
    public Itinerary update(Long id, Itinerary itinerary) {
        itinerary.setId(id);
        return repository.save(itinerary);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // QUERY #3
    public List<Itinerary> byBooking(Long bookingId) {
        return repository.findByBookingId(bookingId);
    }
}
