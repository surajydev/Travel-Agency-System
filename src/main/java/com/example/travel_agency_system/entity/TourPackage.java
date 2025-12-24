package com.example.travel_agency_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tour_package")
@Data
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_package_seq")
    @SequenceGenerator(name = "tour_package_seq", sequenceName = "tour_package_seq", allocationSize = 50)
    private Long id;

    @Column(name = "package_name")
    private String packageName;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(
            name = "tour_package_destinations",
            joinColumns = @JoinColumn(name = "tour_packages_id"),
            inverseJoinColumns = @JoinColumn(name = "destinations_id")
    )
    private List<Destination> destinations;
}
