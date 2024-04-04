package com.company.finalproject1.entity;

import com.company.finalproject1.enums.Options;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "car")
public class CarEntity {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long carId;
    private String carBrand;
    private String carModel;
    private String carColour;
    private Integer carNumber;
    private Integer carYear;
    private String carSize;

    @Enumerated (EnumType.STRING)
    private Options options;




    @OneToOne(mappedBy = "carEntity")
    private DriverEntity driverEntity;





}
