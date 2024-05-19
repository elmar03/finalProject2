package com.company.finalproject1.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

   private String customerName;
   private Double pickupLatitude;
   private Double pickupLongitude;
   private Double destinationLatitude;
   private Double destinationLongitude;

   private Long userId;

}
