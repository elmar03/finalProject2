package com.company.finalproject1.service;

import com.company.finalproject1.configuration.ApiConnect;
import com.company.finalproject1.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiConnectService {

    private  final ApiConnect apiConnect;

    public OrderResponseDto getOrders () {
        return apiConnect.getOrderDetails();
    }
}
