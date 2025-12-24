package com.example.travel_agency_system.repository;

import com.example.travel_agency_system.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {

    // 2️  Find tour packages visiting a specific destination
    @Query("""
        SELECT DISTINCT p
        FROM TourPackage p
        JOIN p.destinations d
        WHERE d.city = :city
    """)
    List<TourPackage> findByDestinationCity(String city);
}
