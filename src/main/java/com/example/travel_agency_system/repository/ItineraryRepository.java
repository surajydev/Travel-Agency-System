package com.example.travel_agency_system.repository;

import com.example.travel_agency_system.entity.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    // 3️ Find itineraries for a booking
    List<Itinerary> findByBookingId(Long bookingId);
}
