package com.company.finalproject1.controller;

import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.service.CarService;
import com.company.finalproject1.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/distance")

public class DistanceController {

    private final DistanceService distanceService;
    private final CarService carService;

    @GetMapping("/nearest-cars")
    public List<CarResponseDto> findNearestCars(@RequestParam double latitude, @RequestParam double longitude) {
        List<CarResponseDto> cars = carService.getAll();
        List<CarResponseDto> nearestCars = distanceService.findFiveNearestCars(cars, latitude, longitude);
        return nearestCars;


    }
}