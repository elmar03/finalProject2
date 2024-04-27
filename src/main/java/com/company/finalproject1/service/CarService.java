package com.company.finalproject1.service;

import com.company.finalproject1.Exception.DriverNotFoundException;
import com.company.finalproject1.configuration.UserApi;
import com.company.finalproject1.dto.CarRequestDto;
import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.dto.Order;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.repository.CarRepo;
import com.company.finalproject1.repository.DriverRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private DriverRepo driverRepo;
    private final CarRepo carRepo;
    private final ModelMapper mapper;






    public List<CarResponseDto> getAll() {
        List<CarEntity> all = carRepo.findAll();
        return all.stream()
                .map(carEntity -> mapper.map(carEntity, CarResponseDto.class))
                .collect(Collectors.toList());
    }

    public void createCar(CarRequestDto carRequestDto) throws DriverNotFoundException {
        CarEntity map = mapper.map(carRequestDto, CarEntity.class);
        Optional<DriverEntity> driver= driverRepo.findById(carRequestDto.getDriverId());
        DriverEntity driverEntity = driver.orElseThrow(() -> new DriverNotFoundException("Driver not found"));
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




