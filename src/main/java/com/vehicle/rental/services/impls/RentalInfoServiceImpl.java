package com.vehicle.rental.services.impls;

import com.vehicle.rental.dtos.RentalInfoDto;
import com.vehicle.rental.entities.RentalInfo;
import com.vehicle.rental.entities.Vehicle;
import com.vehicle.rental.repositories.RentalInfoRepository;
import com.vehicle.rental.repositories.VehicleRepository;
import com.vehicle.rental.services.RentalInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentalInfoServiceImpl implements RentalInfoService {

    @Autowired
    private RentalInfoRepository rentalInfoRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public RentalInfoDto createRentalInfoWithVehicle(String vehicleId, RentalInfoDto rentalInfoDto) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle with given id not found"));
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        rentalInfoDto.setRentalDate(calendar.add(Calendar.DATE, 2));
        rentalInfoDto.setRentalDate(new Date());
        rentalInfoDto.setReturnDate(new Date());
        rentalInfoDto.setVehicle(vehicle);
        RentalInfo rentalInfo = rentalInfoRepository.save(mapper.map(rentalInfoDto, RentalInfo.class));
        return mapper.map(rentalInfo, RentalInfoDto.class);
    }

    @Override
    public RentalInfoDto updateRentalInfo(int rentalId, RentalInfoDto rentalInfoDto) {
        RentalInfo infoToBeUpdated = rentalInfoRepository.findById(rentalId).orElseThrow(() -> new RuntimeException("Rental Info with given id not found"));

        infoToBeUpdated.setRentalDate(rentalInfoDto.getRentalDate());
        infoToBeUpdated.setReturnDate(rentalInfoDto.getReturnDate());
        infoToBeUpdated.setTotalRate(rentalInfoDto.getTotalRate());
        infoToBeUpdated.setReturned(rentalInfoDto.isReturned());
        RentalInfo rentalInfo = rentalInfoRepository.save(infoToBeUpdated);

        return mapper.map(rentalInfo, RentalInfoDto.class);
    }

    @Override
    public void deleteRentalInfo(int rentalId) {
        RentalInfo rentalInfo = rentalInfoRepository.findById(rentalId).orElseThrow(() -> new RuntimeException("Rental Info with given id not found"));
        rentalInfoRepository.delete(rentalInfo);
    }

    @Override
    public List<RentalInfoDto> getAllRentalInfos() {
        List<RentalInfo> infos = rentalInfoRepository.findAll();
        List<RentalInfoDto> rentalInfoDtos = new ArrayList<>();
        for(RentalInfo info : infos) {
            rentalInfoDtos.add(mapper.map(info, RentalInfoDto.class));
        }
        return rentalInfoDtos;
    }

    @Override
    public RentalInfoDto getRentalInfoById(int rentalId) {
        RentalInfo rentalInfo = rentalInfoRepository.findById(rentalId).orElseThrow(() -> new RuntimeException("Rental Info with given Id not found"));
        return mapper.map(rentalInfo, RentalInfoDto.class);
    }

    @Override
    public List<RentalInfoDto> getAllRentalsByVehicleId(String vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle with given id not found"));
        List<RentalInfo> infos = rentalInfoRepository.findAllByVehicle(vehicle);
        List<RentalInfoDto> rentalInfoDtos = new ArrayList<>();
        for(RentalInfo info : infos) {
            rentalInfoDtos.add(mapper.map(info, RentalInfoDto.class));
        }
        return rentalInfoDtos;
    }
}
