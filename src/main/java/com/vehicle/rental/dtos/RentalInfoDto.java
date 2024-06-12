package com.vehicle.rental.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalInfoDto {
    private int rentalId;
    private Date rentalDate;
    private Date returnDate;
    private double totalRate;
    private boolean returned;
    private VehicleDto vehicleDto;
}
