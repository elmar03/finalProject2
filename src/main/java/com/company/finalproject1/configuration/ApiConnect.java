package com.company.finalproject1.configuration;

import com.company.finalproject1.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "CabProject", url = "https://localhost:8080/order")
public interface ApiConnect {

    @GetMapping ("/activeOrders")
    OrderResponseDto getOrderDetails ();







}


