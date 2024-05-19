package com.company.finalproject1.entity;

import com.company.finalproject1.enums.Options;
import jakarta.persistence.*;
import lombok.Data;


   @Entity
   @Data
   @Table(name = "car")
    public class CarEntity {

        @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long carId;
        private String brand;
        private String model;
        private String colour;
        private Integer number;
        private Integer year;
        private String size;
        private Double carLat;
        private Double carLong;

    @Enumerated(EnumType.STRING)
    private Options options;

    @OneToOne(mappedBy = "carEntity")
    private DriverEntity driverEntity;

}
