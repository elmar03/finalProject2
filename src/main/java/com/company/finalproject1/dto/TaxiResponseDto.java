package com.company.finalproject1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxiResponseDto {

    private DriverResponseDto driverResponseDto;
    private CarResponseDto carResponseDto;
    private OrderResponseDto orderResponseDto;
    private Integer price;
}
