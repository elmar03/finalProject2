package com.company.finalproject1.entity;

import com.company.finalproject1.enums.OptionsType;
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
    private OptionsType options;




    //  V(hx - cx)2 + (hy - cy)2


    @OneToOne(mappedBy = "carEntity")
    private DriverEntity driverEntity;

}
