package com.company.finalproject1.entity;

import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.dto.DriverResponseDto;
import com.company.finalproject1.enums.Options;
import com.company.finalproject1.enums.OrderStatus;
import com.company.finalproject1.enums.PaymentMethod;
import com.company.finalproject1.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "orderColumn")
public class OrderEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long   userId;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Double destinationLatitude;
    private Double destinationLongitude;
    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;
    private double distance;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
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
