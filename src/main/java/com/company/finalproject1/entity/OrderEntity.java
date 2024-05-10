package com.company.finalproject1.entity;

import com.company.finalproject1.enums.OptionsType;
import com.company.finalproject1.enums.OrderType;
import com.company.finalproject1.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "orderColumn")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long orderId;
    private String customerName;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Double destinationLatitude;
    private Double destinationLongitude;
    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;
    private double distance;
    private double fare;
    private Long driverId;
    private OrderType orderType;
    private OptionsType optionsType;
    private PaymentType paymentType;


}
