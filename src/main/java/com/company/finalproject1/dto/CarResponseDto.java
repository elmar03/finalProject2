package com.company.finalproject1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDto {

    private Long carId;
    private String carBrand;
    private String carModel;
    private String carColour;
    private Integer carNumber;
    private  Integer carYear;
    private String carSize;

    public CarResponseDto(Long carId, String carBrand, String carModel, String carColour, Integer carNumber, Integer carYear, String carSize) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColour = carColour;
        this.carNumber = carNumber;
        this.carYear = carYear;
        this.carSize = carSize;
    }
}
