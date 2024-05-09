package com.company.finalproject1.entity;

import com.company.finalproject1.dto.CarResponseDto;
import com.company.finalproject1.dto.DriverResponseDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "taxi-response")
public class TaxiResponseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private Integer price;
//    private DriverResponseDto driverResponseDto;
//    private CarResponseDto carResponseDto;

}
