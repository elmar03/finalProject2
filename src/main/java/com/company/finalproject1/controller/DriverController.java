package com.company.finalproject1.controller;

import com.company.finalproject1.dto.DriverRequestDto;
import com.company.finalproject1.dto.DriverResponseDto;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping("/get-driver")
    public List<DriverResponseDto> getAllDrivers () {
        return driverService.getAllDrivers();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDriver(@RequestBody DriverRequestDto driverRequestDto) {
       driverService.createDriver(driverRequestDto);
        return ResponseEntity.ok("Driver is created!");
    }

    @PutMapping("/post")
    public DriverEntity update (@PathVariable Long id, DriverRequestDto driverRequestDto) {
        return driverService.update(id,driverRequestDto);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteDriverById (@PathVariable long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok("Driver is deleted!");
    }
}

