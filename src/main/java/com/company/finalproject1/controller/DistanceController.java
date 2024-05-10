package com.company.finalproject1.controller;

import com.company.finalproject1.dto.*;
import com.company.finalproject1.entity.FeedbackEntity;
import com.company.finalproject1.service.CarService;
import com.company.finalproject1.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping ("/random-price")
    public ResponseEntity<String> getPrice () {
        Integer i = distanceService.priceGenerator();
        return ResponseEntity.ok("The ride price is: " + i+"$");


    }


    @PostMapping("/feedback")
    public FeedbackEntity submitFeedback(@RequestBody FeedbackRequestDto feedback) {
        feedback.setSubmissionDate(new Date());
        return  distanceService.saveFeedback(feedback);


    }

    @PostMapping ("/orderReview")
    public List<TaxiResponseDto> orderReview (@RequestParam Long id) {
        return distanceService.orderReview(id);
    }



}