package com.company.finalproject1.service;

import com.company.finalproject1.dto.DriverRequestDto;
import com.company.finalproject1.dto.DriverResponseDto;
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

    public void createDriver (DriverRequestDto driverRequestDto) {
        DriverEntity map = modelMapper.map(driverRequestDto, DriverEntity.class);
        driverRepo.save(map);
    }

    public void deleteDriver (Long id) {
        driverRepo.deleteById(id);
        ResponseEntity.ok("Driver is deleted!");
    }


    public DriverEntity update (Long id, DriverRequestDto driverRequestDto) {
        DriverEntity byId = driverRepo.findById(id).orElseThrow();
        modelMapper.map(driverRequestDto, byId);
        driverRepo.save(byId);
        return byId;



    }

}
