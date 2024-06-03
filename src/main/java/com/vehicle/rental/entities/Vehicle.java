package com.vehicle.rental.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

    @Column(name = "vehicle_trim")
    private String trim;
}
