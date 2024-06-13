package com.vehicle.rental.services;

import com.vehicle.rental.dtos.RentalInfoDto;

import java.util.List;

public interface RentalInfoService {

    RentalInfoDto createRentalInfoWithVehicle(String vehicleId, RentalInfoDto rentalInfoDto);
    RentalInfoDto updateRentalInfo(int rentalId, RentalInfoDto rentalInfoDto);
    void deleteRentalInfo(int rentalId);
    List<RentalInfoDto> getAllRentalInfos();
    RentalInfoDto getRentalInfoById(int rentalId);
    List<RentalInfoDto> getAllRentalsByVehicleId(String vehicleId);
}
