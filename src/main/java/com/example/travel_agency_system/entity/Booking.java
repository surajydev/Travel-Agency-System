package com.example.travel_agency_system.entity;

import com.example.travel_agency_system.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Itinerary> itineraries;
}
