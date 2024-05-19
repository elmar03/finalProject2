package com.company.finalproject1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaxiResponseDto {

    //  private List<DriverResponseDto> driverResponseDto;
    private List<CarResponseDto> carResponseDto;
   //  private OrderResponseDto orderResponseDto;
    // private Integer price;
}
