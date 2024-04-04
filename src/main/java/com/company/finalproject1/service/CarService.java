package com.company.finalproject1.service;

import com.company.finalproject1.dto.CarRequestDto;
import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.repository.CarRepo;
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





    public List<CarResponseDto> getAll() {
        List<CarEntity> all = carRepo.findAll();
        return all.stream()
                .map(carEntity -> mapper.map(carEntity, CarResponseDto.class))
                .collect(Collectors.toList());
    }

    public void createCar(CarEntity carEntity) {
        CarEntity map = mapper.map(carEntity, CarEntity.class);
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




