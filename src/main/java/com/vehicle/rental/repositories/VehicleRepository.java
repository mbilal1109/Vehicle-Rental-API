package com.vehicle.rental.repositories;

import com.vehicle.rental.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle findByCarClass(String carClass);
}
