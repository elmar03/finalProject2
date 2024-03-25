package com.company.finalproject1.entity;

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

    @OneToOne
    @JoinColumn(name = "driver_id")
    private CarEntity carEntity;




}
