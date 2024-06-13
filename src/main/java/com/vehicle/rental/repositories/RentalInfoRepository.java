package com.vehicle.rental.repositories;

import com.vehicle.rental.entities.RentalInfo;
import com.vehicle.rental.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalInfoRepository extends JpaRepository<RentalInfo, Integer> {
    List<RentalInfo> findAllByVehicle(Vehicle vehicle);
}
