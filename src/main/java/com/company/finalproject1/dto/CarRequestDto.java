package com.company.finalproject1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDto {


    private String brand;
    private String model;
    private String colour;
    private Integer number;
    private Integer year;
    private String size;
    private Double carLat;
    private Double carLong;

    private Long driverId;

}
