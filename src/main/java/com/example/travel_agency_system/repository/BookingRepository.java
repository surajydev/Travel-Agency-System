package com.example.travel_agency_system.repository;

import com.example.travel_agency_system.entity.Booking;
import com.example.travel_agency_system.Enum.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    // 1️ Find all bookings by customer
    List<Booking> findByCustomerId(Long customerId);

    // 4️ Find bookings in a date range
    List<Booking> findByBookingDateBetween(LocalDate start, LocalDate end);

    // 7️ Find upcoming bookings
    List<Booking> findByBookingDateAfter(LocalDate date);

    // 10 Find cancelled / confirmed bookings
    List<Booking> findByStatus(BookingStatus status);

    // 8️  Find bookings with a specific itinerary item
    @Query("""
        SELECT DISTINCT b
        FROM Booking b
        JOIN b.itineraries i
        WHERE i.activity = :activity
    """)
    List<Booking> findByItineraryActivity(String activity);

    // 9 Count bookings per tour package
    @Query("""
        SELECT b.tourPackage.id, COUNT(b)
        FROM Booking b
        GROUP BY b.tourPackage.id
    """)
    List<Object[]> countBookingsPerTourPackage();
}
