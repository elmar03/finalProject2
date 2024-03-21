package com.company.finalproject1.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table
public class DriverEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long driverId;
    private  String driverName;
    private  String driverSurname;
    private String driverLanguage;


}
