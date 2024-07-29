package com.company.finalproject1.entity;

import com.company.finalproject1.enums.OrderStatus;
import com.company.finalproject1.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "drivers")
public class DriverEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long driverId;
    private String username;
    private String password;
    private String role;
    private  String driverName;
    private  String driverSurname;
    private String driverLanguage;



    @Enumerated (EnumType.STRING)
    @Column(name = "order_type")
    private OrderStatus orderType;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private CarEntity carEntity;



}
