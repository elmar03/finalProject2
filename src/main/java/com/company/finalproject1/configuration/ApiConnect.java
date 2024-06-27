package com.company.finalproject1.configuration;

import com.company.finalproject1.dto.FeedbackResponseDto;
import com.company.finalproject1.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "CabProject", url = "http://localhost:8085")
public interface ApiConnect {

    @GetMapping ("/order/activeOrders")
    OrderResponseDto getOrderDetails ();

    @PostMapping("/order/sendOrder")
    OrderResponseDto acceptOrder();

    @GetMapping("/feedBack/feedbackByOrderId")
    List<FeedbackResponseDto> acceptFeedback(long OrderID);


}


