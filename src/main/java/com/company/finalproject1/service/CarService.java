package com.company.finalproject1.service;

import com.company.finalproject1.Exception.DriverNotFoundException;
import com.company.finalproject1.dto.CarRequestDto;
import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.dto.TaxiResponseDto;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.entity.TaxiResponseEntity;
import com.company.finalproject1.repository.CarRepo;
import com.company.finalproject1.repository.DriverRepo;
import com.company.finalproject1.repository.TaxiResponseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepo carRepo;
    private final ModelMapper mapper;
    private final DriverRepo driverRepo;
    private final TaxiResponseRepo taxiResponseRepo;

    public List<CarResponseDto> getAll() {
        List<CarEntity> all = carRepo.findAll();
        return all.stream()
                .map(carEntity -> mapper.map(carEntity, CarResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<TaxiResponseDto> getAllNew() {
        List<CarEntity> all = carRepo.findAll().stream().toList();
        return all.stream().map(CarEntity->
                mapper.map(CarEntity,TaxiResponseDto.class)).toList();
    }

    public void createCar(CarRequestDto carRequestDto) throws DriverNotFoundException {
        CarEntity map = mapper.map(carRequestDto, CarEntity.class);
        DriverEntity driverEntity = driverRepo.findById(carRequestDto.getDriverId()).orElseThrow(() ->
        new  DriverNotFoundException("Driver not found"));
        map.setDriverEntity(driverEntity);
        carRepo.save(map);
    }

    public void deleteCar(Long id) {
        carRepo.deleteById(id);
        ResponseEntity.ok("Car is deleted!");
    }




    public CarEntity update (Long id, CarRequestDto carRequestDto) {
        CarEntity byId = carRepo.findById(id).orElseThrow();
         mapper.map(carRequestDto, byId);
         carRepo.save(byId);

        return byId;
    }



}




