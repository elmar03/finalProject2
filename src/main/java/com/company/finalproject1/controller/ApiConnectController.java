package com.company.finalproject1.controller;

import com.company.finalproject1.dto.OrderResponseDto;
import com.company.finalproject1.service.ApiConnectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiConnectController {

    private  final ApiConnectService apiConnectService;

    @GetMapping("/order-detail")
    public OrderResponseDto getOrderDetail () {
        return apiConnectService.getOrders();
    }


}
