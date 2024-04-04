package com.company.finalproject1.entity;

import com.company.finalproject1.enums.Order;
import com.company.finalproject1.enums.Payment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table
public class DriverEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long driverId;
    private  String driverName;
    private  String driverSurname;
    private String driverLanguage;

    @Enumerated (EnumType.STRING)
    private Order order;
    @Enumerated(EnumType.STRING)
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private CarEntity carEntity;




}
