package com.company.finalproject1.service;

import com.company.finalproject1.dto.CarResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistanceService {

    private ModelMapper mapper;



    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    public int calculateDistanceInKilometer(double userLat, double userLong,
                                            double carLat, double carLong) {

        double latDistance = Math.toRadians(userLat - carLat);
        double lngDistance = Math.toRadians(userLong - carLong);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(carLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c) * 1000);
    }




    public List <CarResponseDto> findFiveNearestCars(List<CarResponseDto> cars, double userLat, double userLng) {
        List <CarResponseDto> nearestCars = cars.stream()
                .sorted(Comparator.comparingInt(car -> calculateDistanceInKilometer(car.getCarId(), car.getNumber(), userLat, userLng)))
                .limit(5)
                .collect(Collectors.toList());
        return nearestCars;
    }

}
