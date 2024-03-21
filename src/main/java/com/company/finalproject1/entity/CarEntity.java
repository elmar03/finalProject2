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
public class CarEntity {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long carId;
    private String carBrand;
    private String carModel;
    private String carColour;
    private Integer carNumber;
    private  Integer carYear;
    private String carSize;

}
