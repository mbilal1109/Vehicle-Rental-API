package com.vehicle.rental.dtos;

import com.vehicle.rental.entities.RentalInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
    private String vehicleId;
    private String make;
    private String model;
    private String year;
    private String vehicleClass;
    private Double dailyRate;
}
