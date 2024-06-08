package com.vehicle.rental.services;

import com.vehicle.rental.dtos.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);
    VehicleDto updateVehicle(String vehicleId, VehicleDto vehicleDto);
    void deleteVehicle(String vehicleId);
    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleById(String vehicleId);
    List<VehicleDto> getVehiclesByClass(String vehicleClass);
    List<VehicleDto> getDailyRateLessThanEqual(Double dailyRate);
}
