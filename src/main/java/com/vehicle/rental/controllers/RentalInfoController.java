package com.vehicle.rental.controllers;

import com.vehicle.rental.dtos.RentalInfoDto;
import com.vehicle.rental.services.RentalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalInfoController {

    @Autowired
    private RentalInfoService rentalInfoService;

    @PostMapping("/{vehicleId}/infos")
    public ResponseEntity<RentalInfoDto> createRentalInfoWithVehicle(@PathVariable String vehicleId, @RequestBody RentalInfoDto rentalInfoDto) {
        RentalInfoDto rentalInfoToBeCreated = rentalInfoService.createRentalInfoWithVehicle(vehicleId, rentalInfoDto);
        return new ResponseEntity<>(rentalInfoToBeCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RentalInfoDto>> getAllRentalInfos() {
        List<RentalInfoDto> rentalInfoDtos = rentalInfoService.getAllRentalInfos();
        return new ResponseEntity<>(rentalInfoDtos, HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}/vehicle")
    public ResponseEntity<List<RentalInfoDto>> getAllRentalsByVehicle(@PathVariable String vehicleId) {
        List<RentalInfoDto> rentalInfoDtos = rentalInfoService.getAllRentalsByVehicleId(vehicleId);
        return new ResponseEntity<>(rentalInfoDtos, HttpStatus.OK);
    }
}
