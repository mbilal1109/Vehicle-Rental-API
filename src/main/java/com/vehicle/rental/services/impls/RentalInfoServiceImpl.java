package com.vehicle.rental.services.impls;

import com.vehicle.rental.dtos.RentalInfoDto;
import com.vehicle.rental.services.RentalInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalInfoServiceImpl implements RentalInfoService {
    @Override
    public RentalInfoDto createRentalInfoWithVehicle(RentalInfoDto rentalInfoDto) {
        return null;
    }

    @Override
    public RentalInfoDto updateRentalInfo(int rentalId, RentalInfoDto rentalInfoDto) {
        return null;
    }

    @Override
    public void deleteRentalInfo(int rentalId) {

    }

    @Override
    public List<RentalInfoDto> getAllRentalInfos() {
        return null;
    }

    @Override
    public RentalInfoDto getRentalInfoById(int rentalId) {
        return null;
    }
}
