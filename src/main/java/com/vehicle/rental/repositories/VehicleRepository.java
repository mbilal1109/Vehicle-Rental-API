package com.vehicle.rental.repositories;

import com.vehicle.rental.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findAllByVehicleClass(String vehicleClass);
    List<Vehicle> findByDailyRateLessThanEqual(Double dailyRate);
}
