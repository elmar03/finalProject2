package com.company.finalproject1.service;

import com.company.finalproject1.dto.*;
import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.entity.FeedbackEntity;
import com.company.finalproject1.entity.OrderEntity;
import com.company.finalproject1.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DistanceService {

    private final ModelMapper mapper;
    private final FeedbackRepo feedbackRepo;
    private final TaxiResponseRepo taxiResponseRepo;
    private  final DriverRepo driverRepo;
    private final CarRepo carRepo;
    private final OrderRepo orderRepo;



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

    public Integer priceGenerator () {
        Random rand = new Random();
        return rand.nextInt (21)+10;
    }

    public FeedbackEntity saveFeedback(FeedbackRequestDto feedbackRequestDto) {
        FeedbackEntity feedbackEntity = mapper.map(feedbackRequestDto, FeedbackEntity.class);
        feedbackRepo.save(feedbackEntity);
        return feedbackEntity;
    }


//    public  List<TaxiResponseDto> orderReview (Long orderId) {
//        Integer price = priceGenerator();
//        List <TaxiResponseDto> responseList = new ArrayList<>();
//        OrderEntity orderEntity = orderRepo.findById(orderId).orElseThrow();
//        DriverEntity driverEntity = driverRepo.findById((orderEntity.getDriverId())).orElseThrow() ;
//        DriverResponseDto driverResponseDto = mapper.map(driverEntity, DriverResponseDto.class);
//        CarEntity carEntity = carRepo.findById(orderEntity.getDriverId()).orElseThrow();
//        CarResponseDto carResponseDto = mapper.map(carEntity, CarResponseDto.class);
//
//        TaxiResponseDto responseDto = new TaxiResponseDto();
//        responseDto.setDriverResponseDto(driverResponseDto);
//        responseDto.setCarResponseDto(carResponseDto);
//        responseDto.setPrice(price);
//        responseList.add(responseDto);
//        return responseList;
//     }

    public  List<TaxiResponseDto> orderReview () {
        List <TaxiResponseDto> responseList = new ArrayList<>();
        List<CarEntity> carEntities = carRepo.findAll();
        List<CarResponseDto> carResponseDTos = carEntities.stream()
                .map(carEntity -> {
                    CarResponseDto carResponseDTO = mapper.map(carEntity, CarResponseDto.class);
                    Optional<DriverEntity> driverEntity = driverRepo.findById(carEntity.getCarId());
                    if (driverEntity != null){
                        DriverResponseDto driverResponseDTO = mapper.map(driverEntity, DriverResponseDto.class);
                        carResponseDTO.setDriverResponseDto(driverResponseDTO);
                        Integer price = priceGenerator();
                        carResponseDTO.setPrice(price);
                    }
                    return carResponseDTO;
                })
                .collect(Collectors.toList());
        TaxiResponseDto responseDto = new TaxiResponseDto();
        responseDto.setCarResponseDto(carResponseDTos);
        responseList.add(responseDto);
        return responseList;
     }
    }











