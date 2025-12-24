package com.example.travel_agency_system.repository;

import com.example.travel_agency_system.entity.Destination;
import com.example.travel_agency_system.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {


    // QUERY 5: Find most popular destinations (by booking count)

    @Query("""
        SELECT d
        FROM Destination d
        JOIN d.tourPackages p
        JOIN Booking b ON b.tourPackage = p
        GROUP BY d
        ORDER BY COUNT(b) DESC
    """)
    List<Destination> findMostPopularDestinations();
}
