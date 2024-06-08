package com.vehicle.rental.controllers;

import com.vehicle.rental.commons.VehicleRentalResponseMessage;
import com.vehicle.rental.dtos.VehicleDto;
import com.vehicle.rental.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable String vehicleId, @RequestBody VehicleDto vehicleDto) {
        VehicleDto updatedVehicle = vehicleService.updateVehicle(vehicleId, vehicleDto);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable String vehicleId) {
        VehicleDto vehicleDto = vehicleService.getVehicleById(vehicleId);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicleDtos = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<VehicleRentalResponseMessage> deleteVehicle(@PathVariable String vehicleId) {
        vehicleService.deleteVehicle(vehicleId);

        VehicleRentalResponseMessage message = VehicleRentalResponseMessage
                .builder()
                .message("Vehicle Deleted Successfully")
                .success(true)
                .status(HttpStatus.OK)
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/class/{vehicleClass}")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByClass(@PathVariable String vehicleClass) {
        List<VehicleDto> vehicleDtos = vehicleService.getVehiclesByClass(vehicleClass);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/rate/{dailyRate}")
    public ResponseEntity<List<VehicleDto>> getDailyRateLessThanEqual(@PathVariable Double dailyRate) {
        List<VehicleDto> vehicleDtos = vehicleService.getDailyRateLessThanEqual(dailyRate);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }
}
