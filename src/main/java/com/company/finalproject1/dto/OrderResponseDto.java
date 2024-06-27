package com.company.finalproject1.dto;

import com.company.finalproject1.enums.Options;
import com.company.finalproject1.enums.OrderStatus;
import com.company.finalproject1.enums.PaymentMethod;
import com.company.finalproject1.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDto {
    private String orderId;
    private Long   userId;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Double destinationLatitude;
    private Double destinationLongitude;
    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;
    private double distance;

    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Options options;

    private Long carId;
    private String brand;
    private String model;
    private String colour;
    private Integer number;
    private  Integer year;
    private String size;
    private Double carLat;
    private Double carLong;


    private Long driverId;
    private  String driverName;
    private  String driverSurname;
    private String driverLanguage;

    private Integer price;

    private Integer user_review;

}
