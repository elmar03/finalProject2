package com.company.finalproject1.service;

import com.company.finalproject1.dto.CarRequestDto;
import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.dto.DriverRequestDto;
import com.company.finalproject1.dto.DriverResponseDto;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.repository.DriverRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private  final DriverRepo driverRepo;
    private final ModelMapper modelMapper;


    public DriverService(DriverRepo driverRepo, ModelMapper modelMapper) {
        this.driverRepo = driverRepo;
        this.modelMapper = modelMapper;
    }

    public List<DriverResponseDto> getAllDrivers() {
        List<DriverEntity> allDrivers = driverRepo.findAll();
        return allDrivers.stream()
                .map(driverEntity -> modelMapper.map(driverEntity, DriverResponseDto.class))
                .collect(Collectors.toList());
    }

    public void createDriver (DriverEntity driverEntity) {
        DriverEntity map = modelMapper.map(driverEntity, DriverEntity.class);
        driverRepo.save(map);
    }

    public void deleteDriver (Long id) {
        driverRepo.deleteById(id);
        ResponseEntity.ok("Driver deleted!");
    }

    public DriverResponseDto update (Long id, DriverRequestDto driverRequestDto) {
        DriverEntity byId = driverRepo.findById(id).orElseThrow();
        byId.setDriverName(driverRequestDto.getDriverName());
        byId.setDriverSurname(driverRequestDto.getDriverSurname());
        byId.setDriverLanguage(driverRequestDto.getDriverLanguage());
        DriverEntity save = driverRepo.save(byId);

        return modelMapper.map(save, DriverResponseDto.class);

    }

}
