package com.company.finalproject1.service;

import com.company.finalproject1.configuration.ApiConnect;
import com.company.finalproject1.dto.DriverResponseDto;
import com.company.finalproject1.dto.OrderResponseDto;
import com.company.finalproject1.entity.OrderEntity;
import com.company.finalproject1.repository.CarRepo;
import com.company.finalproject1.repository.DriverRepo;
import com.company.finalproject1.repository.OrderRepo;
import com.company.finalproject1.repository.TaxiResponseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CarRepo carRepo;
    private final ModelMapper mapper;
    private final DriverRepo driverRepo;
    private final TaxiResponseRepo taxiResponseRepo;

    private final OrderRepo orderRepo;
    private final ApiConnect apiConnect;

    public void saveOrder(){
        OrderResponseDto orderResponseDto = apiConnect.acceptOrder();
        OrderEntity map = mapper.map(orderResponseDto, OrderEntity.class);
        map.setOrderStatus(orderResponseDto.getOrderStatus());
        map.setOptions(orderResponseDto.getOptions());
        map.setPaymentMethod(orderResponseDto.getPaymentMethod());
        map.setPaymentStatus(orderResponseDto.getPaymentStatus());

        orderRepo.save(map);
    }



}
