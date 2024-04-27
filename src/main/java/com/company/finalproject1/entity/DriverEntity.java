package com.company.finalproject1.entity;

import com.company.finalproject1.enums.OrderType;
import com.company.finalproject1.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "drivers")
public class DriverEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long driverId;
    private  String driverName;
    private  String driverSurname;
    private String driverLanguage;




    @Enumerated (EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private PaymentType payment;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private CarEntity carEntity;




}
