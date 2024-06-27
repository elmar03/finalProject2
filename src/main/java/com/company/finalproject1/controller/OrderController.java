package com.company.finalproject1.controller;

import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/acceptOrder")
    public void saveOrder() {
        orderService.saveOrder();
    }




}
