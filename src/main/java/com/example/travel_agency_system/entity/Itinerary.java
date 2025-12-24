package com.example.travel_agency_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Entity
@Table(name = "itinerary")
@Data
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itinerary_seq")
    @SequenceGenerator(name = "itinerary_seq", sequenceName = "itinerary_seq", allocationSize = 50)
    private Long id;

    private String activity;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;
}
