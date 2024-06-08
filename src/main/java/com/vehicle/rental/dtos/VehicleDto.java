package com.vehicle.rental.dtos;

import lombok.*;

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
