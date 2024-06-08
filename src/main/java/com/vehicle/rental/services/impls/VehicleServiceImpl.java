package com.vehicle.rental.services.impls;

import com.vehicle.rental.dtos.VehicleDto;
import com.vehicle.rental.entities.Vehicle;
import com.vehicle.rental.repositories.VehicleRepository;
import com.vehicle.rental.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        String vehicleId = UUID.randomUUID().toString();
        vehicleDto.setVehicleId(vehicleId);

        Vehicle vehicle = vehicleRepository.save(mapper.map(vehicleDto, Vehicle.class));
        return mapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto updateVehicle(String vehicleId, VehicleDto vehicleDto) {
        Vehicle vehicleToBeUpdated = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found with given Id"));

        vehicleToBeUpdated.setMake(vehicleDto.getMake());
        vehicleToBeUpdated.setModel(vehicleDto.getModel());
        vehicleToBeUpdated.setYear(vehicleDto.getYear());
        vehicleToBeUpdated.setVehicleClass(vehicleDto.getVehicleClass());
        vehicleToBeUpdated.setDailyRate(vehicleDto.getDailyRate());
        Vehicle vehicle = vehicleRepository.save(vehicleToBeUpdated);

        return mapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found with given Id"));
        vehicleRepository.delete(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.map(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public VehicleDto getVehicleById(String vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found with given Id"));
        return mapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getVehiclesByClass(String vehicleClass) {
        List<Vehicle> vehicles = vehicleRepository.findAllByVehicleClass(vehicleClass);
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.map(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> getDailyRateLessThanEqual(Double dailyRate) {
        List<Vehicle> vehicles = vehicleRepository.findByDailyRateLessThanEqual(dailyRate);
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.map(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }
}
