package com.vehicle.rental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "vehicle_make")
    private String make;

    @Column(name = "vehicle_model")
    private String model;

    @Column(name = "vehicle_year")
    private String year;

    @Column(name = "vehicle_class")
    private String vehicleClass;

    @Column(name = "vehicle_daily_rate")
    private Double dailyRate;

    @OneToMany
    @JoinColumn(name = "vehicle_id")
    private List<RentalInfo> rentalInfos;
}