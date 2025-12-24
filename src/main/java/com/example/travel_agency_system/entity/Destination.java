package com.example.travel_agency_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "destination")
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "destination_seq")
    @SequenceGenerator(name = "destination_seq", sequenceName = "destination_seq", allocationSize = 50)
    private Long id;

    private String city;
    private String country;

    @ManyToMany(mappedBy = "destinations")
    @JsonIgnore
    private List<TourPackage> tourPackages;
}
