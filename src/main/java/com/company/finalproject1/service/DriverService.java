package com.company.finalproject1.service;

import com.company.finalproject1.dto.DriverRequestDto;
import com.company.finalproject1.dto.DriverResponseDto;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.entity.OrderEntity;
import com.company.finalproject1.enums.OrderType;
import com.company.finalproject1.repository.CarRepo;
import com.company.finalproject1.repository.DriverRepo;
import com.company.finalproject1.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {

    private  final DriverRepo driverRepo;
    private final ModelMapper modelMapper;
    private final OrderRepo orderRepo;
    private final CarRepo carRepo;




    public List<DriverResponseDto> getAllDrivers() {
        List<DriverEntity> allDrivers = driverRepo.findAll();
        return allDrivers.stream()
                .map(driverEntity -> modelMapper.map(driverEntity, DriverResponseDto.class))
                .collect(Collectors.toList());
    }

    public void createDriver (DriverRequestDto driverRequestDto) {
        DriverEntity map = modelMapper.map(driverRequestDto, DriverEntity.class);
        driverRepo.save(map);
    }

    public void deleteDriver (Long id) {
        driverRepo.deleteById(id);
        ResponseEntity.ok("Driver is deleted!");
    }


    public DriverEntity update (Long id, DriverRequestDto driverRequestDto) {
        DriverEntity byId = driverRepo.findById(id).orElseThrow();
        modelMapper.map(driverRequestDto, byId);
        driverRepo.save(byId);
        return byId;



    }


//    public void cancelledByDriver(Long id){
//        DriverEntity driverEntity = driverRepo.findById(id).orElseThrow();
//       driverEntity.setOrderType(OrderType.CANCELED);
//    }


    public OrderEntity completeOrder(Long id) {
        OrderEntity orderEntity = orderRepo.findById(id).orElseThrow();

        if (orderEntity.getOrderType() == OrderType.ACCEPTED) {
            orderEntity.setOrderType(OrderType.PENDING);

        } else if (orderEntity.getOrderType() == OrderType.PENDING) {
            orderEntity.setOrderType(OrderType.COMPLETED);
            orderRepo.save(orderEntity);

        } else {
            throw new RuntimeException("Invalid order status");
        }

        return orderEntity;
    }





}


