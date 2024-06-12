package com.vehicle.rental.repositories;

import com.vehicle.rental.entities.RentalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalInfoRepository extends JpaRepository<RentalInfo, Integer> {
}
