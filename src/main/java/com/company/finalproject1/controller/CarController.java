package com.company.finalproject1.controller;

import com.company.finalproject1.dto.CarRequestDto;
import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/get-all")
    public List<CarResponseDto> getAllCar () {
        return carService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCar(@RequestBody CarRequestDto carRequestDto) {
        carService.createCar(carRequestDto);
        return ResponseEntity.ok("Car is created!");
    }

    @PutMapping("/post{id}")
    public CarEntity update (@PathVariable long id, CarRequestDto carRequestDto) {
        return carService.update(id, carRequestDto);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteCarById (@PathVariable long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Car is deleted!");
    }


}
